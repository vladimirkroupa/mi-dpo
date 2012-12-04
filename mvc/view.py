from observer import ShapeObserver
from Tkinter import *
import Pmw
from model import Shape

class CanvasView(Frame, ShapeObserver):

    def __init__(self, model, controller, parent=None):
        Frame.__init__(self, parent)
        self.canvas = Canvas(self, bg='white', cursor='pencil')
        self.canvas.pack(side=LEFT)

        self.shapes = {}
        self.register(model)
        self.bindController(controller)

    def register(self, model):
        model.registerObserver(self)

    def bindController(self, controller):
        self.canvas.bind('<ButtonPress-1>', controller.onLeftClick)
        self.canvas.bind('<ButtonPress-3>', controller.onRightClick)
        self.canvas.bind('<B1-Motion>', controller.onLeftClick)
        self.canvas.bind('<B3-Motion>', controller.onRightClick)

    def drawCircle(self, shape):
        return self.canvas.create_oval(shape.x, shape.y, shape.x + shape.size, shape.y + shape.size)

    def drawSquare(self, shape):
        return self.canvas.create_rectangle(shape.x, shape.y, shape.x + shape.size, shape.y + shape.size)

    def drawShape(self, shape):
        if shape.type == 'circle':
            obj_id = self.drawCircle(shape)
        elif shape.type == 'square':
            obj_id = self.drawSquare(shape)
        else:
            raise ValueError('Uknown shape ', shape.type)
        self.shapes[shape.id] = obj_id

    def onShapeCreated(self, shape):
        self.drawShape(shape)

    def onShapeMoved(self, shape_id, new_x, new_y):
        obj_id = self.shapes[shape_id]
        old_coords = self.canvas.coords(obj_id)
        old_x = old_coords[0]
        old_y = old_coords[1]
        self.canvas.move(obj_id, new_x - old_x, new_y - old_y)

    def onShapeResized(self, shape_id, new_size):
        obj_id = self.shapes.pop(shape_id)
        coords = self.canvas.coords(obj_id)

        #TODO: use canvas.scale !
        self.canvas.delete(obj_id)
        self.drawShape(Shape(shape_id, coords[0], coords[1], new_size, 'circle'))

    def onShapeDeleted(self, shape_id):
        obj_id = self.shapes[shape_id]
        self.canvas.delete(obj_id)

class TableView(Frame, ShapeObserver):

    def __init__(self, model, controller, shape_type, parent=None):
        Frame.__init__(self, parent)
        self.sf = Pmw.ScrolledFrame(parent, vscrollmode='static')
        self.sf.pack()
        self.rows = 0
        self.controller = controller

        self.shape_type = shape_type
        self.row_mapping = {}
        self.register(model)

        self.addHeader()


    def addHeader(self):
        id_header = Label(self.sf.interior(), text='id', width=10, bg='gray96')
        id_header.grid(row=self.rows, column=0, padx=1, pady=2)

        x_header = Label(self.sf.interior(), text='x', width=10, bg='gray96')
        x_header.grid(row=self.rows, column=1, padx=1, pady=2)

        y_header = Label(self.sf.interior(), text='y', width=10, bg='gray96')
        y_header.grid(row=self.rows, column=2, padx=1, pady=2)

        size_header = Label(self.sf.interior(), text='size', width=10, bg='gray96')
        size_header.grid(row=self.rows, column=3, padx=1, pady=2)

        self.rows += 1

    def addEntry(self, text, shape_id, col):
        str_var = StringVar(value=text)
        entry = Entry(self.sf.interior(), textvariable=str_var, width=10)
        entry.grid(row=self.rows, column=col)
        return entry

    def addShape(self, shape):
        id = Label(self.sf.interior(), text='%s' % shape.id, width=10, bg='white')
        id.grid(row=self.rows, column=0)

        x = self.addEntry(shape.x, shape.id, 1)
        x.bind('<Return>', lambda event, shape_id = shape.id: self.controller.onXChanged(shape_id, int(x.get())))
        y = self.addEntry(shape.y, shape.id, 2)
        y.bind('<Return>', lambda event, shape_id = shape.id: self.controller.onYChanged(shape_id, int(y.get())))
        size = self.addEntry(shape.size, shape.id, 3)
        size.bind('<Return>', lambda event, shape_id = shape.id: self.controller.onSizeChanged(shape_id, int(size.get())))

        row = (id, x, y, size)
        self.row_mapping[shape.id] = row
        self.rows += 1

    def register(self, model):
        model.registerObserver(self)

    def onShapeCreated(self, shape):
        if shape.type == self.shape_type:
            self.addShape(shape)

    def onShapeMoved(self, shape_id, new_x, new_y):
        row = self.row_mapping.pop(shape_id, None)
        if row:
            x_label = row[1]
            x_label.delete(0, END)
            x_label.insert(0, new_x)

            y_label = row[2]
            y_label.delete(0, END)
            y_label.insert(0, new_y)

    def onShapeResized(self, shape_id, new_size):
        row = self.row_mapping.pop(shape_id, None)
        if row:
            size_label = row[3]
            size_label.delete(0, END)
            size_label.insert(0, new_size)

    def onShapeDeleted(self, shape_id):
        row = self.row_mapping.pop(shape_id, None)
        if row:
            for item in row:
                item.grid_forget()
                item.destroy()

class ClearAllButtonView(Frame):

    def __init__(self, controller, parent=None):
        Frame.__init__(self, parent)
        Button(self, text='Clear all', command=controller.onDeleteAllClick).pack(side=LEFT)

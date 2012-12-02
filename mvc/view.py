from observer import ShapeObserver
from Tkinter import *
import Pmw

class CanvasView(Frame, ShapeObserver):

    def __init__(self, model, controller, parent=None):
        Frame.__init__(self, parent)
        self.canvas = Canvas(self, bg='white', cursor='pencil')
        self.canvas.pack(side=LEFT)

        self.shapes = {}
        self.register(model)
        self.setController(controller)

    def register(self, model):
        model.registerObserver(self)

    def setController(self, controller):
#        self.counter = 0
#        def filter(function):
#            if self.counter % 5 == 0:
#                function()
#            counter += 1

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

    def moveShape(self, shape):
        obj_id = self.shapes[shape.id]
        self.canvas.coords(obj_id, [shape.x, shape.y])

    def onShapeEvent(self, shape):
        if shape.id in self.shapes:
            self.moveShape(shape)
        else:
            self.drawShape(shape)

class TableView(Frame, ShapeObserver):

    def __init__(self, model, shape_type, parent=None):
        Frame.__init__(self, parent)
        self.sf = Pmw.ScrolledFrame(parent)
        self.sf.pack()
        self.rows = 0

        self.shape_type = shape_type
        self.shapes = []
        self.register(model)

    def addShape(self, shape):
        self.shapes.append(shape)
        id = Label(self.sf.interior(), text='%s' % shape.id, width=10)
        x = Entry(self.sf.interior(), width=10)
        x.insert(0, shape.x)
        y = Entry(self.sf.interior(), width=10)
        y.insert(0, shape.y)
        id.grid(row=self.rows, column=0)
        x.grid(row=self.rows, column=1)
        y.grid(row=self.rows, column=2)
        self.rows += 1

    def register(self, model):
        model.registerObserver(self)

    def onShapeEvent(self, shape):
        if shape.type == self.shape_type and shape.id not in self.shapes:
            self.addShape(shape)




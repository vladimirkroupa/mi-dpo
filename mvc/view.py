from observer import ShapeObserver
from tkinter import *

class View(Frame, ShapeObserver):

    def __init__(self, model, controller, parent=None):
        Frame.__init__(self, parent)
        self.shapes = {}
        self.canvas = Canvas()
        self.canvas.pack(side=LEFT)
        self.register(model)
        self.setController(controller)

    def register(self, model):
        model.registerObserver(self)

    def setController(self, controller):
        self.canvas.bind('<ButtonPress-1>', controller.onLeftClick)
        self.canvas.bind('<ButtonPress-3>', controller.onRightClick)

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

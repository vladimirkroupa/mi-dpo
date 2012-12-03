from random import randint
from observer import ShapeObservable

class Shape:

    def __init__(self, id, x, y, size, type):
        self.id = id
        self.x = x
        self.y = y
        self.size = size
        self.type = type

    def distanceFrom(self, shape):
        return self.x - shape.x, self.y - shape.y

class Model(ShapeObservable):

    def __init__(self):
        ShapeObservable.__init__(self)
        self.circles = {}
        self.squares = {}

    def createSquare(self, x, y, size=20):
        id = randint(0, 10000000)
        square = Shape(id, x, y, size, 'square')
        self.squares[id] = square
        self.notifyShapeEvent(square)

    def createCircle(self, x, y, size=10):
        id = randint(0, 10000000)
        circle = Shape(id, x, y, size, 'circle')
        self.circles[id] = circle
        self.notifyShapeEvent(circle)

    def updateX(self, shape_id, new_value):
        #shape = self.circles.get(shape_id)

    def removeAll(self):
        for shape in self.circles.itervalues():
            self.notifyShapeDelete(shape.id)
        for shape in self.squares.itervalues():
            self.notifyShapeDelete(shape.id)
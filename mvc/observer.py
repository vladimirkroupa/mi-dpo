class ShapeObserver:

    def onShapeCreated(self, shape):
        pass

    def onShapeMoved(self, shape_id, new_x, new_y):
        pass

    def onShapeResized(self, shape_id, new_size):
        pass

    def onShapeDeleted(self, shape_id):
        pass

class ShapeObservable:

    def __init__(self):
        self._observers = []

    def registerObserver(self, observer):
        self._observers.append(observer)

    def deregisterObserver(self, observer):
        self._observers.remove(observer)

    def notifyShapeCreated(self, shape):
        for observer in self._observers:
            observer.onShapeCreated(shape)

    def notifyShapeMoved(self, shape):
        for observer in self._observers:
            observer.onShapeMoved(shape.id, shape.x, shape.y)

    def notifyShapeResized(self, shape):
        for observer in self._observers:
            observer.onShapeResized(shape.id, shape.size)

    def notifyShapeDeleted(self, shape_id):
        for observer in self._observers:
            observer.onShapeDeleted(shape_id)
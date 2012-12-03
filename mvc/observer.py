class ShapeObserver:

    def onShapeEvent(self, shape):
        pass

    def onShapeDelete(self, shape_id):
        pass

class ShapeObservable:

    def __init__(self):
        self._observers = []

    def registerObserver(self, observer):
        self._observers.append(observer)

    def deregisterObserver(self, observer):
        self._observers.remove(observer)

    def notifyShapeEvent(self, shape):
        for observer in self._observers:
            observer.onShapeEvent(shape)

    def notifyShapeDelete(self, shape_id):
        for observer in self._observers:
            observer.onShapeDelete(shape_id)
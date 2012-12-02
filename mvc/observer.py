class ShapeObserver:

    def onShapeEvent(self, shape):
        pass

class ShapeObservable:

    def __init__(self):
        self._observers = []

    def registerObserver(self, observer):
        self._observers.append(observer)

    def deregisterObserver(self, observer):
        self._observers.remove(observer)

    def notifyObservers(self, shape):
        for observer in self._observers:
            observer.onShapeEvent(shape)

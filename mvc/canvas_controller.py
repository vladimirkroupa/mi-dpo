class CanvasController:

    def __init__(self, model):
        self.model = model

    def eventPosition(self, event):
        return event.x, event.y

    def onLeftClick(self, event):
        x, y = self.eventPosition(event)
        self.model.createCircle(x, y)

    def onRightClick(self, event):
        x, y = self.eventPosition(event)
        self.model.createSquare(x, y)


class ButtonController:

    def __init__(self, model):
        self.model = model

    def onDeleteAllClick(self):
        self.model.removeAll()
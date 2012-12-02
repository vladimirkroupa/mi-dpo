class Controller:

    def __init__(self, model):
        self.model = model

    def eventPosition(self, event):
        return event.x, event.y

    def onLeftClick(self, event):
        x, y = self.eventPosition(event)
        model_id = self.model.createCircle(x, y)

    def onRightClick(self, event):
        x, y = self.eventPosition(event)
        model_id = self.model.createSquare(x, y)

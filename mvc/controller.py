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


class TableController:

    def __init__(self, model):
        self.model = model

    def onXChanged(self, shape_id, new_value):
        self.model.updateX(shape_id, new_value)

    def onYChanged(self, shape_id, new_value):
        self.model.updateY(shape_id, new_value)

    def onSizeChanged(self, shape_id, new_value):
        self.model.updateSize(shape_id, new_value)

class ButtonController:

    def __init__(self, model):
        self.model = model

    def onDeleteAllClick(self):
        self.model.removeAll()
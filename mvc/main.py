from Tkinter import *
from model import Model
from canvas_controller import *
from view import *

if __name__ == '__main__':
    root = Tk()
    model = Model()
    canvas_controller = CanvasController(model)
    view = CanvasView(model, canvas_controller, root)
    view.pack(side=LEFT)

    table_frame = Frame()
    table_frame.pack(side=RIGHT)

    circles_table = TableView(model, 'circle', table_frame)
    circles_table.pack(side=TOP)

    squares_table = TableView(model, 'square', table_frame)
    squares_table.pack(side=BOTTOM)

    button_controller = ButtonController(model)
    clear_button = ClearAllButtonView(button_controller, table_frame)
    clear_button.pack(side=BOTTOM)

    root.mainloop()

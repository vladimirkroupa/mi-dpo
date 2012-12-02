from Tkinter import *
from model import Model
from controller import Controller
from view import *

if __name__ == '__main__':
    root = Tk()
    model = Model()
    controller = Controller(model)
    view = CanvasView(model, controller, root)
    view.pack(side=LEFT)

    table_frame = Frame()
    table_frame.pack(side=RIGHT)

    circles_table = TableView(model, 'circle', table_frame)
    circles_table.pack(side=TOP)

    squares_table = TableView(model, 'square', table_frame)
    squares_table.pack(side=BOTTOM)

    root.mainloop()

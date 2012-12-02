from tkinter import *
from model import Model
from controller import Controller
from view import View

if __name__ == '__main__':
    root = Tk()
    model = Model()
    controller = Controller(model)
    view = View(model, controller, root)
    view.pack()

    root.mainloop()

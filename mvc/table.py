from Tkinter import *
import Pmw

class ExampleApp:
    def __init__(self):
        self.root = Tk()
        Pmw.initialise(self.root)
        t = SimpleTable(self.root, 100, 2)
        t.pack(side=TOP, fill=X)
        t = SimpleTable(self.root, 50, 2)
        t.pack(side=BOTTOM, fill=X)
        t.set(0,0,"Hello, world")

class SimpleTable(Frame):
    def __init__(self, parent, rows=10, columns=2):
        # use black background so it "peeks through" to
        # form grid lines
        Frame.__init__(self, parent, background="black")
        self.sf = Pmw.ScrolledFrame(parent)
        self.sf.pack()
        self._widgets = []
        for row in range(rows):
            current_row = []

            label = Label(self.sf.interior(), text="%s/%s" % (row, 0), borderwidth=0, width=10)
            label.grid(row=row, column=0, sticky="nsew", padx=1, pady=1)
            current_row.append(label)

            entry = Entry(self.sf.interior(), width=20)
            entry.grid(row=row, column=1, padx=1, pady=1)
            entry.insert(0, 'mnamnour')
            current_row.append(entry)

            self._widgets.append(current_row)

    def set(self, row, column, value):
        widget = self._widgets[row][column]
        widget.configure(text=value)

if __name__ == "__main__":
    app = ExampleApp()
    app.root.mainloop()
import javax.swing.*;

public class BoardSizeModel extends DefaultComboBoxModel <BoardSize> {
    public BoardSizeModel() {
        for (int i = 2; i <= 10; i+=2){
            addElement(new BoardSize(i));
        }

    }
}

class BoardSize {
    private int size;

    public BoardSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return size + "x" + size;
    }
}
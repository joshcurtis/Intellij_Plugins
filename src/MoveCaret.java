import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Caret;

public class MoveCaret extends AnAction {
  final int columnShift;
  final int lineShift;

  public MoveCaret(int columnShift, int lineShift) {
    this.columnShift = columnShift;
    this.lineShift = lineShift;
  }

  @Override
  public void actionPerformed(AnActionEvent e) {
    Object navigable = e.getData(CommonDataKeys.NAVIGATABLE);
    boolean selection = false;
    boolean scroll = true;
    Caret caret = e.getData(CommonDataKeys.CARET);
    if (caret != null) {
      caret.moveCaretRelatively(columnShift, lineShift, selection, scroll);
    }
  }
}

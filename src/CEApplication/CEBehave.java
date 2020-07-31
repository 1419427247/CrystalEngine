package CEApplication;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public abstract class CEBehave implements CEPerfab {
	public CEBehave() {

	}

	protected abstract void Start();

	protected abstract void Update();

	protected abstract void Destroy();

	@Override
	public void convertToObject(Node root) {

	}

	@Override
	public void convertToNode(Document document, Node root) {
		Field[] fields = this.getClass().getFields();
		for (Field field : fields) {
			try {
				if (!Modifier.isStatic(field.getModifiers())) {
					// if (field.get(this) instanceof CEPerfab) {
					// 	root.appendChild(CEApplication.xml.convertToNode(document, (CEPerfab) field.get(this)));
					// } else {
					// }
					root.appendChild(CEApplication.xml.convertToNode(document, field.getName(), field.get(this)));
				}
			} catch (DOMException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}

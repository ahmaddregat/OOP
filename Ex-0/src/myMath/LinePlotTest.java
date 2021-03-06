package myMath;
/**
 * The path from which we took the code:https://github.com/eseifert/gral.git
 * 
 */
import java.awt.Color;
import javax.swing.JFrame;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.plots.points.PointRenderer;
import de.erichseifert.gral.ui.InteractivePanel;


public class LinePlotTest extends JFrame {

	public LinePlotTest() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		Polynom p1=new Polynom("2x^2+5");
//		p1.add(new Monom(1,2));
//		p1.add(new Monom(5,0));
		DataTable data = new DataTable(Double.class, Double.class);
		for (double x = -5.0; x <= 5.0; x+=0.25) {
			double y = p1.f(x);
			data.add(x, y);
		}
		XYPlot plot = new XYPlot(data);
		getContentPane().add(new InteractivePanel(plot));
		LineRenderer lines = new DefaultLineRenderer2D();
		plot.setLineRenderers(data,lines);
		Color color = new Color(0.0f, 0.3f, 1.0f);
		plot.getPointRenderers(data).get(0).setColor(color);
		plot.getLineRenderers(data).get(0).setColor(color);
	}

	public static void main(String[] args) {
		LinePlotTest frame = new LinePlotTest();
		frame.setVisible(true);
	}
}
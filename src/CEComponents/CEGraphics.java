package CEComponents;

import CEApplication.*;
import CEWindows.*;

public abstract class CEGraphics extends CEComponent
{
	public abstract void drawPoints(float[] pts, int offset, int count, CEPaint paint) ;

    public abstract void drawPoints(float[] pts, CEPaint paint) ;

    public abstract void drawPoint(float x, float y, CEPaint paint) ;

    public abstract void drawLine(float startX, float startY, float stopX, float stopY, CEPaint paint) ;

    public abstract void drawLines(float[] pts, int offset, int count, CEPaint paint) ;

    public abstract void drawLines(float[] pts, CEPaint paint) ;

    public abstract void drawRect(CERect rect, CEPaint paint) ;

    public abstract void drawRect(float left, float top, float right, float bottom, CEPaint paint) ;

    public abstract void drawOval(CERect oval, CEPaint paint) ;

    public abstract void drawOval(float left, float top, float right, float bottom, CEPaint paint) ;

    public abstract void drawCircle(float cx, float cy, float radius, CEPaint paint) ;

    public abstract void drawArc(CERect oval, float startAngle, float sweepAngle, boolean useCenter, CEPaint paint) ;

    public abstract void drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, CEPaint paint) ;

    public abstract void drawRoundRect(CERect rect, float rx, float ry, CEPaint paint) ;

    public abstract void drawRoundRect(float left, float top, float right, float bottom, float rx, float ry, CEPaint paint) ;

    public abstract void drawText(char[] text, int index, int count, float x, float y, CEPaint paint) ;

    public abstract void drawText(String text, float x, float y, CEPaint paint) ;

    public abstract void drawText(String text, int start, int end, float x, float y, CEPaint paint) ;

    public abstract void drawText(CharSequence text, int start, int end, float x, float y, CEPaint paint) ;

    public abstract void drawTextRun(char[] text, int index, int count, int contextIndex, int contextCount, float x, float y, boolean isRtl, CEPaint paint) ;

    public abstract void drawTextRun(CharSequence text, int start, int end, int contextStart, int contextEnd, float x, float y, boolean isRtl, CEPaint paint) ;

    public abstract void drawPosText(String text, float[] pos, CEPaint paint) ;

    public abstract void drawPicture(CEPicture picture) ;

    public abstract void drawPicture(CEPicture picture, CERect dst) ;
}

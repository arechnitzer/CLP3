                  /*  File:  polarArea.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polarArea extends Template {

     static {templateClass = new polarArea() ; }

     public void setup() {
          filePrefix = "polarArea" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.3 ;      // in inches
          ysize = 1.3 ;   // in inches
          xmin = -1 ;
          xmax = 6 ;
          ymin = -1 ;
          ymax = 6 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;
          double a = Math.PI/12 ;
          double b = Math.PI/2.5 ;

          double dth  = (b-a)/4 ;
          double th1 = a+ dth ;
          double th2 = a+ 2*dth ;
          double x1 = (3+2*Math.sin(th1))*Math.cos(th1);
          double y1 = (3+2*Math.sin(th1))*Math.sin(th1);
          double x2 = (3+2*Math.sin(th2))*Math.cos(th2);
          double y2 = (3+2*Math.sin(th2))*Math.sin(th2);
          double[] xlist = {0, x1, x2} ;
          double[] ylist = {0, y1, y2} ;
          fEnv("psFillGray", 0.8) ;
          fPolygon(xlist, ylist, 3, FILLED) ;
          fCurve("[(3+2*sin(t))*cos(t),(3+2*sin(t))*sin(t)]", 1,
                  th1, th2, FILLED);


          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          fEnv("lineWidth", 1.0) ;
          fCurve("[(3+2*sin(t))*cos(t),(3+2*sin(t))*sin(t)]", 1,
                  a, b, OPEN);
          fLine(0,0, (3+2*Math.sin(a))*Math.cos(a),(3+2*Math.sin(a))*Math.sin(a)) ;
          fLine(0,0, (3+2*Math.sin(b))*Math.cos(b),(3+2*Math.sin(b))*Math.sin(b)) ;
          canvas.append( new fPsWrite(Black+"\n")) ;


          fEnv("lineWidth", 0.5) ;
          fCurve("[(3+2*sin(t))*cos(t),(3+2*sin(t))*sin(t)]", 1,
                  Math.PI/24, Math.PI/2.2, OPEN);
          fLine(0,0, 6*Math.cos(a),  6*Math.sin(a)) ;
          fLine(0,0, 6*Math.cos(b),  6*Math.sin(b)) ;
          double th = a+dth ;
          fLine(0,0,(3+2*Math.sin(th))*Math.cos(th),(3+2*Math.sin(th))*Math.sin(th));
          th += dth ;
          fLine(0,0,(3+2*Math.sin(th))*Math.cos(th),(3+2*Math.sin(th))*Math.sin(th));
          th += dth ;
          fLine(0,0,(3+2*Math.sin(th))*Math.cos(th),(3+2*Math.sin(th))*Math.sin(th));
          th += dth ;
          fLine(0,0,(3+2*Math.sin(th))*Math.cos(th),(3+2*Math.sin(th))*Math.sin(th));

          double ab2 = 0.5*a + 0.5*b ;
          fTeXlabel(6*Math.cos(a)+0.1,  6*Math.sin(a), "bl", "$\\theta=a$") ;
          fTeXlabel(6*Math.cos(b)+0.1,  6*Math.sin(b), "bl", "$\\theta=b$") ;
          fTeXlabel(4.3*Math.cos(ab2)+0.1,  4.3*Math.sin(ab2), "bl", "$r=f(\\theta)$") ;

     }
}

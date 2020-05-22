                  /*  File:  polarArea2.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polarArea2 extends Template {

     static {templateClass = new polarArea2() ; }

     public void setup() {
          filePrefix = "polarArea2" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 6*0.25 ;      // in inches
          ysize = 5*0.25 ;   // in inches
          xmin = -1 ;
          xmax = 5 ;
          ymin = -1 ;
          ymax = 4 ;
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


          fEnv("lineWidth", 0.2) ;
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

          fEnv("psFillGray", 0.8) ;
          fCurve("[(3+2*sin(t))*cos(t),(3+2*sin(t))*sin(t)]", 1,
                  th1, th2, FILLED);
          double[] xlist = {0, x1, x2} ;
          double[] ylist = {0, y1, y2} ;
          fPolygon(xlist, ylist, 3, FILLED) ;


          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          fEnv("lineWidth", 1.0) ;
          fCurve("[(3+2*sin(t))*cos(t),(3+2*sin(t))*sin(t)]", 1,
                  th1, th2, OPEN);

          fLine(0,0, x1, y1) ;
          fLine(0,0, x2, y2) ;
          canvas.append( new fPsWrite(Black+"\n")) ;

          fEnv("lineWidth", 0.5) ;
          fLine(x1,y1, 0.95*x1, 0.95*y1) ;
          fLine(x2,y2, 1.05*x2, 1.05*y2) ;

          fLine(0,0, 1.05*(3+2*Math.sin(th2))*Math.cos(th1),
                        1.05*(3+2*Math.sin(th2))*Math.sin(th1)) ;
          fEllipticalArc(0,0, 0.95*(3+2*Math.sin(th1)), 0.95*(3+2*Math.sin(th1)),
                     th1*180/Math.PI, th2*180/Math.PI, OPEN) ;
          fEllipticalArc(0,0, 1.05*(3+2*Math.sin(th2)), 1.05*(3+2*Math.sin(th2)),
                     th1*180/Math.PI, th2*180/Math.PI, OPEN) ;

          fTeXlabel(0.95*x1-0.1, 0.95*y1-0.2, "tl", "$r_i$") ;
          fTeXlabel(1.05*x2, 1.05*y2+0.05, "bl", "$R_i$") ;



     }
}

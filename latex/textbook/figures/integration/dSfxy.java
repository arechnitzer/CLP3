                  /*  File:  dSfxy.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class dSfxy extends Template {

     static {templateClass = new dSfxy() ; }

     public void setup() {
          filePrefix = "dSfxy" ;    // used as the prefix for any ps, lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0;      // in inches
          ysize = 1.0 ;   // in inches
          xmin = -10 ;
          xmax = 10 ;
          ymin = -10 ;
          ymax = 10 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 1.0) ;
          double A = -0.025 ; 
          double x1 = -6.0 ; double y1 = -7.0 ;
          double x2 = 5.0 ; double y2 = -5.0 ;
          double x3 = 6.0 ; double y3 = 6.0 ;
          double x4 = -5.0 ; double y4 = 5.0 ;
          double r = 0.6; 
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fCurve(new paraY(A, x1, y1, x2, y2), -10,10,OPEN)  ;
          fCurve(new paraY(A, x4, y4, x3, y3), -10,10,OPEN)  ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          A = -0.025 ; 
          fCurve(new paraX(A, x1, y1, x4, y4), -10,10,OPEN)  ;
          fCurve(new paraX(A, x2, y2, x3, y3), -10,10,OPEN)  ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fDisk(x1,y1, r, r, FILLED) ;
          fDisk(x2,y2, r, r, FILLED) ;
          fDisk(x3,y3, r, r, FILLED) ;
          fDisk(x4,y4, r, r, FILLED) ;
//          fTeXlabel(x1,y1, "br", "$P_0=\\vr(u_0,v_0)$") ;
          fTeXlabel(x1-0.7,y1, "br", "$P_2$") ;
          fTeXlabel(x2-0.1,y2+0.5, "br", "$P_3$") ;
          fTeXlabel(x3-0.5,y3+0.5, "br", "$P_1$") ;
          fTeXlabel(x4-0.5,y4+0.1, "br", "$P_0$") ;

          fTeXlabel(9.6,y2-1.0, "cl", 
                  "${\\scriptstyle\\atp{x=x_0+\\dee{x}}{y{\\rm\\ varying }}}$");
          fTeXlabel(9.7,y3-1.4, "cl", 
                  "${\\scriptstyle\\atp{x=x_0}{y{\\rm\\ varying }}}$");
          fTeXlabel(x3-1,10.6, "cb", 
                  "${\\scriptstyle\\atp{x{\\rm\\ varying }}{y=y_0+\\dee{y}}}$");
          fTeXlabel(x4-2,10.6, "cb", 
                  "${\\scriptstyle\\atp{x{\\rm\\ varying }}{y=y_0}}$");
     }
}


class paraY implements S2V {

     double A = 1 ;
     double B = 1 ;
     double C = 1 ;
     double x1 = -1 ;
     double y1 = 0 ;
     double x2 = 1 ;
     double y2 = 0 ;

   public paraY(double A, double x1, double y1,  double x2, double y2) { 
        this.A = A ;
        this.x1 = x1 ;
        this.y1 = y1 ;
        this.x2 = x2 ;
        this.y2 = y2 ;
        B = (y1-A*x1*x1  -y2+A*x2*x2) / (x1-x2) ;
        C = y1 - A*x1*x1 - B*x1 ;
   }

     public double[] map(double t) {
          double[] out = {0,0} ;
          out[0] = t ;
          out[1] = A*t*t +B*t +C ;
          return out ;
   }
}


class paraX implements S2V {

     double A = 1 ;
     double B = 1 ;
     double C = 1 ;
     double y1 = -1 ;
     double x1 = 0 ;
     double y2 = 1 ;
     double x2 = 0 ;

   public paraX(double A, double x1, double y1,  double x2, double y2) { 
        this.A = A ;
        this.x1 = x1 ;
        this.y1 = y1 ;
        this.x2 = x2 ;
        this.y2 = y2 ;
        B = (x1-A*y1*y1  -x2+A*y2*y2) / (y1-y2) ;
        C = x1 - A*y1*y1 - B*y1 ;
   }

     public double[] map(double t) {
          double[] out = {0,0} ;
          out[1] = t ;
          out[0] = A*t*t +B*t +C ;
          return out ;
   }
}

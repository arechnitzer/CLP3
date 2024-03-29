                  /*  File:  rigid.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class rigid extends Template {

     static {templateClass = new rigid() ; }

     public void setup() {
          filePrefix = "rigid" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;     
          ysize = 2 ;  
          xmin = -30 ;
          xmax = 70 ;
          ymin = 0 ;
          ymax = 100 ;
          topmargin = 0 ;   // in inches
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
          fEnv("headHalfWidth", 2*1.3) ;
          fEnv("headLength", 6*1.3) ;
          double th = -10*Math.PI/180 ;
          double Xx = Math.cos(th) ;
          double Xy = Math.sin(th) ;
          double Yx = -Math.sin(th) ;
          double Yy = Math.cos(th) ;
          fLine( 0, 0, 95*Yx, 95*Yy) ;
          fArrow( 0, 0,75*Yx, 75*Yy) ;
          fArrow( 0, 0, 40*Xx+50*Yx, 40*Xy+50*Yy) ;
          fCurve(new ellipse2d(0,0, 12*Xx,12*Xy, 12*Yx, 12*Yy), 51,90,OPEN)  ;
          fCurve(new ellipse2d(50*Yx, 50*Yy, 40*Xx,40*Xy, 12*Yx, 12*Yy),
                                 0,360,CLOSED)  ;
          fArrow( 40*Xx+50*Yx, 40*Xy+50*Yy,  30*Xx+70*Yx, 30*Xy+70*Yy) ;
          fCurve(new ellipse2d(85*Yx, 85*Yy, 10*Xx,10*Xy, 5*Yx, 5*Yy), 
                                 130,410,OPEN)  ;
          fArrowhead( 6*Xx+89*Yx, 6*Xy+89*Yy, 150) ;

          fTeXlabel( 43*Xx+50*Yx,  43*Xy+50*Yy, "cc", "$P$") ;
          fTeXlabel( 25*Xx+25*Yx,  25*Xy+25*Yy, "cc", "$\\vr$") ;
          fTeXlabel( 31*Xx+70*Yx,  31*Xy+70*Yy, "bl", "$\\vv$") ;
          fTeXlabel( -1,  -1, "tr", "$\\vZero$") ;
          fTeXlabel( 2*Xx+73*Yx,  2*Xy+73*Yy, "lc", "$\\hat\\va$") ;
          fTeXlabel( 6*Xx+18*Yx,  6*Xy+18*Yy, "cc", "$\\theta$") ;
          fTeXlabel( 14*Xx+85*Yx,  14*Xy+85*Yy, "cc", "$\\Omega$") ;

          
     }
}

class ellipse2d implements S2V {

     double cx = 0.0 ;
     double cy = 0.0 ;
     double xa = 100.0 ;
     double ya = 0.0 ;
     double xb = 0.0 ;
     double yb = 100.0 ;


   public ellipse2d(double cx, double cy, 
                    double xa, double ya, 
                    double xb, double yb) {
        this.cx = cx ;
        this.cy = cy ;
        this.xa = xa ;
        this.ya = ya ;
        this.xb = xb ;
        this.yb = yb ;
   }

     public double[] map(double t) {
          
          double[] out = {0,0} ;
          out[0] = cx+xa*Math.cos(t*Math.PI/180)+xb*Math.sin(t*Math.PI/180) ;
          out[1] = cy+ya*Math.cos(t*Math.PI/180)+yb*Math.sin(t*Math.PI/180) ;
          return out ;
   }
}


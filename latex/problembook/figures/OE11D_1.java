                  /*  File:  OE11D_1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE11D_1 extends Template {

     static {templateClass = new OE11D_1() ; }

     public void setup() {
          filePrefix = "OE11D_1" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 10.0*0.3 ;      // in inches
          ysize = 6.0*0.3 ;   // in inches. 
          xmin = -5 ;
          xmax = 5 ;
          ymin = -3 ;
          ymax = 3 ;
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
         double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
         double r = 0.1 ;
         fEnv("lineWidth", 0.5) ;
         fLine(xmin, 0, xmax, 0) ;
         fLine(0, 0, 0, ymax) ;
         fLine(0, ymin, 0, -0.4) ;
         fTeXlabel(xmax, -0.1, "tr", "$x$") ;
         fTeXlabel(-0.1, ymax, "tr", "$y$") ;
         String Red = "0 1 1 0 setcmykcolor  " ;
         String Blue = "1 1 0 0 setcmykcolor  " ;
         String Black = "0 0 0 1 setcmykcolor  " ;
         fEnv("useColorPs", "true") ;


           double C ;
           canvas.append( new fPsWrite(Red+"\n")) ;
           fEnv("psFillColor", Red) ;
           fEnv("lineWidth", 1.0) ;
           C = 0; fLine(xmin, xmin/2, xmax,xmax/2) ;
                  fLine(xmin, -xmin/2, xmax,-xmax/2) ;
                  fTeXlabel(0.0,-0.12, "tc", "${\\scriptstyle f=1}$") ;

           C = 1; fCurve(new FY(+1,C), xmin, xmax, OPEN) ;
                  fTeXlabel(0.8,0.8, "cb", "${\\scriptstyle f=e}$") ;
                  fCurve(new FY(-1,C), xmin, xmax, OPEN) ;
                  fTeXlabel(0.8,-0.8, "ct", "${\\scriptstyle f=e}$") ;

           C = 9; fCurve(new FY(+1,C), xmin, xmax, OPEN) ;
                  fTeXlabel(1,1.7, "cb", "${\\scriptstyle f=e^9}$") ;
                  fCurve(new FY(-1,C), xmin, xmax, OPEN) ;
                  fTeXlabel(1,-1.8, "ct", "${\\scriptstyle f=e^9}$") ;

           C = -1; fCurve(new FX(+1,C), xmin, xmax, OPEN) ;
                   fTeXlabel(1.5,0.2, "bl", "${\\scriptstyle f=e^{-1}}$") ;
                   fCurve(new FX(-1,C), xmin, xmax, OPEN) ;
                   fTeXlabel(-1.6,0.2, "br", "${\\scriptstyle f=e^{-1}}$") ;

           C = -9; fCurve(new FX(+1,C), xmin, xmax, OPEN) ;
                   fTeXlabel(3.2,0.2, "bl", "${\\scriptstyle f=e^{-9}}$") ;
                   fCurve(new FX(-1,C), xmin, xmax, OPEN) ;
                   fTeXlabel(-3.3,0.2, "br", "${\\scriptstyle f=e^{-9}}$") ;
          
     }
}

class FY implements S2V {

   double C = 10 ;
   double S = +1 ;

   public FY(double S, double C) {
        this.C = C ;
        this.S = S ;
   }


   public double[] map(double t) {
          
          double[] out = {0,0} ;
          out[0] = t  ;
          out[1] =   0.5*S*Math.sqrt( t*t+C ) ;
          return out ;
   }
}


class FX implements S2V {

   double C = 10 ;
   double S = +1 ;

   public FX(double S, double C) {
        this.C = C ;
        this.S = S ;
   }


   public double[] map(double t) {
          
          double[] out = {0,0} ;
          out[1] = t  ;
          out[0] =   S*Math.sqrt( 4*t*t - C ) ;
          return out ;
   }
}


                  /*  File:  noLimD.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class noLimD extends Template {

     static {templateClass = new noLimD() ; }

     public void setup() {
          filePrefix = "noLimD" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.75 ;    
          ysize = 2.75 ;   
          xmin = -0.01 ;
          xmax = 0.7 ;
          ymin = -0.01 ;
          ymax = 0.7 ;
          topmargin = 0.3 ;   // in inches
          bottommargin = 0.2  ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.4) ;
          fLine(xmin,0, xmax,0) ;
          fLine(0,ymin, 0, ymax) ;
//          fTeXlabel(-0.025, ymax, "tr", "$y$") ;
//          fTeXlabel(xmax, -0.025, "tr", "$x$") ;

          double H = 1 ; double x = 0 ;
          fEnv("lineWidth", 0.4) ;
          fCurve(new cmap(H), -2, 1, OPEN) ;
          x = H-4 +Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
          x = x/8 ;
//          fTeXlabel(x, -1.02, "tc", "$1$") ;
          x = H-4 -Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
          x = x/8 ;
//          fTeXlabel(x, -1.02, "tc", "$1$") ;

          H = -1; fCurve(new cmap(H), -1, 1, OPEN) ;
          x = H+4 +Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
          x = x/8 ;
//          fTeXlabel(x, 1.02, "bc", "$-1$") ;
          x = H+4 -Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
          x = x/8 ;
//          fTeXlabel(x, 1.02, "bc", "$-1$") ;

          H = 2; fCurve(new cmap(H), -1, 2, OPEN) ;
          x = H-4 +Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
          x = x/8 ;
//          fTeXlabel(x, -1.02, "tc", "$2$") ;
          x = H-4 -Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
          x = x/8 ;
//          fTeXlabel(x, -1.02, "tc", "$2$") ;

          H = -2; fCurve(new cmap(H), -2, 1, OPEN) ;
          x = H+4 +Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
          x = x/8 ;
//          fTeXlabel(x, 1.02, "bc", "$-2$") ;
          x = H+4 -Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
          x = x/8 ;
//          fTeXlabel(x, 1.02, "bc", "$-2$") ;

          H = 3; fCurve(new cmap(H), -4, 4, OPEN) ;
          x = H-4 +Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
          x = x/8 ;
//          fTeXlabel(x, -1.02, "tc", "$f=3$") ;
          x = H-4 -Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
          x = x/8 ;
//          fTeXlabel(x, -1.02, "tc", "$3$") ;

          H = -3; fCurve(new cmap(H), -4, 4, OPEN) ;
          x = H+4 +Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
          x = x/8 ;
//          fTeXlabel(x, 1.02, "bc", "$-3$") ;
          x = H+4 -Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
          x = x/8 ;
//          fTeXlabel(x, 1.02, "bc", "$-3$") ;

          H = 0.5; fCurve(new cmap(H), -1, 1, OPEN) ;
          x = H-4 +Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
          x = x/8 ;
//          fTeXlabel(x, -1.02, "tc", "$\\half$") ;
          x = H-4 -Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
          x = x/8 ;
//          fTeXlabel(x, -1.02, "tc", "$\\half$") ;

          H = -0.5; fCurve(new cmap(H), -1, 1, OPEN) ;
          x = H+4 +Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
          x = x/8 ;
//          fTeXlabel(x, 1.02, "bc", "$-\\half$") ;
          x = H+4 -Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
          x = x/8 ;
//          fTeXlabel(x, 1.02, "bc", "$-\\half$") ;

          fEnv("lineWidth", 0.8) ;
          fLine(-1,-1,  1,1) ;
          fTeXlabel(xmax, ymax+.01, "bc", "$y=x$") ;

          fCurve("y = x - x*x*x", 0, -1, 1, OPEN) ;
          fTeXlabel(xmax+0.02, xmax-xmax*xmax*xmax, "cl", "$y=x-x^3$") ;

          

     }
}



class cmap implements S2V {

   double H = 10 ;

   public cmap(double H) {
        this.H = H ;
   }


   public double[] map(double t) {
          
          double[] out = {0,0} ;
          out[0] = t - t*t/H ;
          out[1] = t - 2*t*t/H ;
          return out ;
   }
}


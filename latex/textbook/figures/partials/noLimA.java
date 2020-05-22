                  /*  File:  noLimA.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class noLimA extends Template {

     static {templateClass = new noLimA() ; }

     public void setup() {
          filePrefix = "noLimA" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.75 ;    
          ysize = 2.75 ;   
          xmin = -1 ;
          xmax = 1 ;
          ymin = -1 ;
          ymax = 1 ;
          topmargin = 0.2 ;   // in inches
          bottommargin = 0.2 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0, xmax,0) ;
          fLine(0,ymin, 0, ymax) ;
          fTeXlabel(-0.025, ymax, "tr", "$y$") ;
          fTeXlabel(xmax, -0.025, "tr", "$x$") ;

          double H = 1 ; double x = 0 ;
          fEnv("lineWidth", 1.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve(new cmap(H), -2, 1, OPEN) ;
          x = H-4 +Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
          x = x/8 ;
          fTeXlabel(x, -1.02, "tc", "$1$") ;
          x = H-4 -Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
          x = x/8 ;
//          fTeXlabel(x, -1.02, "tc", "$1$") ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          H = -1; fCurve(new cmap(H), -1, 1, OPEN) ;
          x = H+4 +Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
          x = x/8 ;
//          fTeXlabel(x, 1.02, "bc", "$-1$") ;
          x = H+4 -Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
          x = x/8 ;
//          fTeXlabel(x, 1.02, "bc", "$-1$") ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          H = 2; fCurve(new cmap(H), -1, 2, OPEN) ;
          x = H-4 +Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
          x = x/8 ;
          fTeXlabel(x, -1.02, "tc", "$2$") ;
          x = H-4 -Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
          x = x/8 ;
//          fTeXlabel(x, -1.02, "tc", "$2$") ;

          canvas.append( new fPsWrite(Red+"\n")) ;
          H = -2; fCurve(new cmap(H), -2, 1, OPEN) ;
          x = H+4 +Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
          x = x/8 ;
//          fTeXlabel(x, 1.02, "bc", "$-2$") ;
          x = H+4 -Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
          x = x/8 ;
//          fTeXlabel(x, 1.02, "bc", "$-2$") ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          H = 3; fCurve(new cmap(H), -4, 4, OPEN) ;
          x = H-4 +Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
          x = x/8 ;
          fTeXlabel(x, -1.02, "tc", "$f=3$") ;
          x = H-4 -Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
          x = x/8 ;
//          fTeXlabel(x, -1.02, "tc", "$3$") ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          H = -3; fCurve(new cmap(H), -4, 4, OPEN) ;
          x = H+4 +Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
          x = x/8 ;
//          fTeXlabel(x, 1.02, "bc", "$-3$") ;
          x = H+4 -Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
          x = x/8 ;
//          fTeXlabel(x, 1.02, "bc", "$f=-3$") ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          H = 0.5; fCurve(new cmap(H), -1, 1, OPEN) ;
          x = H-4 +Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
          x = x/8 ;
          fTeXlabel(x, -1.02, "tc", "$\\half$") ;
          x = H-4 -Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
          x = x/8 ;
//          fTeXlabel(x, -1.02, "tc", "$\\half$") ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          H = -0.5; fCurve(new cmap(H), -1, 1, OPEN) ;
          x = H+4 +Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
          x = x/8 ;
//          fTeXlabel(x, 1.02, "bc", "$-\\half$") ;
          x = H+4 -Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
          x = x/8 ;
//          fTeXlabel(x, 1.02, "bc", "$-\\half$") ;

          fEnv("lineWidth", 1.0) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
//          fLine(-1,-1,  1,1) ;
//          fTeXlabel(1, 1.02, "bc", "$y=x$") ;
          double th = 0.75*Math.PI/4 ;
          fLine(0, 0, 2*Math.cos(th), 2*Math.sin(th) ) ;
          fTeXlabel(1.02, Math.tan(th), "cl", "$\\theta=\\frac{3}{16}\\pi$") ;
          th = 0.5*Math.PI/4 ;
          fLine(0, 0, 2*Math.cos(th), 2*Math.sin(th) ) ;
          fTeXlabel(1.02, Math.tan(th), "cl", "$\\theta=\\frac{1}{8}\\pi$") ;
          
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


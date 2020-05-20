                  /*  File:  noLimS.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class noLimS extends Template {

     static {templateClass = new noLimS() ; }

     public void setup() {
          filePrefix = "noLimS" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.5 ;    
          ysize = 3.5*1.5/2.0 ;   
          xmin = -1 ;
          xmax = 1 ;
          ymin = -0.5 ;
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
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.0) ;
//          fCurve(new cmap(H), -2, 1, OPEN) ;
//          x = H-4 +Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
//          x = x/8 ;
//          fTeXlabel(x, -1.02, "tc", "$1$") ;
//          x = H-4 -Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
//          x = x/8 ;
////          fTeXlabel(x, -1.02, "tc", "$1$") ;

//          canvas.append( new fPsWrite(Black+"\n")) ;
//          H = -1; fCurve(new cmap(H), -1, 1, OPEN) ;
//          x = H+4 +Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
//          x = x/8 ;
////          fTeXlabel(x, 1.02, "bc", "$-1$") ;
//          x = H+4 -Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
//          x = x/8 ;
//          fTeXlabel(x, 1.02, "bc", "$-1$") ;

//          canvas.append( new fPsWrite(Blue+"\n")) ;
//          H = 2; fCurve(new cmap(H), -1, 2, OPEN) ;
//          x = H-4 +Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
//          x = x/8 ;
//          fTeXlabel(x, -1.02, "tc", "$2$") ;
//          x = H-4 -Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
//          x = x/8 ;
//          fTeXlabel(x, -1.02, "tr", "$f=2$") ;

//          canvas.append( new fPsWrite(Red+"\n")) ;
//          H = -2; fCurve(new cmap(H), -2, 1, OPEN) ;
//          x = H+4 +Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
//          x = x/8 ;
////          fTeXlabel(x, 1.02, "bc", "$-2$") ;
//          x = H+4 -Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
//          x = x/8 ;
//          fTeXlabel(x, 1.02, "bc", "$-2$") ;

//          canvas.append( new fPsWrite(Black+"\n")) ;
//          H = 3; fCurve(new cmap(H), -4, 4, OPEN) ;
//          x = H-4 +Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
//          x = x/8 ;
//          fTeXlabel(x, -1.02, "tc", "$3$") ;
//          x = H-4 -Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
//          x = x/8 ;
////          fTeXlabel(x, -1.02, "tc", "$3$") ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          H = -3; fCurve(new cmap(H), -4, 4, OPEN) ;
          x = H+4 +Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
          x = x/8 ;
          fTeXlabel(x, 1.02, "bc", "$-3$") ;
          x = H+4 -Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
          x = x/8 ;
          fTeXlabel(x, 1.02, "bc", "$f=-3$") ;

//          canvas.append( new fPsWrite(Black+"\n")) ;
//          H = 0.5; fCurve(new cmap(H), -1, 1, OPEN) ;
//          x = H-4 +Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
//          x = x/8 ;
//          fTeXlabel(x, -1.02, "tc", "$\\half$") ;
//          x = H-4 -Math.sqrt( (H-4)*(H-4) +16*(H-1) ) ;
//          x = x/8 ;
//          fTeXlabel(x, -1.02, "tc", "$\\half$") ;

//          canvas.append( new fPsWrite(Blue+"\n")) ;
//          H = -0.5; fCurve(new cmap(H), -1, 1, OPEN) ;
//          x = H+4 +Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
//          x = x/8 ;
//          fTeXlabel(x, 1.02, "bc", "$-\\half$") ;
//          x = H+4 -Math.sqrt( (H+4)*(H+4) -16*(H+1) ) ;
//          x = x/8 ;
//          fTeXlabel(x, 1.02, "bc", "$-\\half$") ;

//          fEnv("lineWidth", 1.0) ;
//          fLine(-1,-1,  1,1) ;
//          fTeXlabel(1, 1.02, "bc", "$y=x$") ;



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


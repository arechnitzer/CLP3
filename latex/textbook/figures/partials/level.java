                  /*  File:  level.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class level extends Template {

     static {templateClass = new level() ; }

     public void setup() {
          filePrefix = "level" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 2 ;   // in inches. 
          xmin = -50 ;
          xmax = 50 ;
          ymin = -50 ;
          ymax = 50 ;
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
          double c = 0.5 ;
          double um = -100 ;
          double uM = 100 ;
          double nu = 10 ;
          double du = (uM-um)/nu ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0, xmax,0) ;
          fLine(0,ymin,0,ymax) ;
          fTeXlabel(xmax+2,0, "cl", "$t$") ;
          fTeXlabel(0, ymax+2, "cb", "$x$") ;

          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("lineWidth", 1.0) ;
          canvas.append( new fPsWrite(Red+"\n")) ;

          double u = um ;
          for ( int i=0; i <= nu ; i++ ) {
               fLine( (u-ymin)/c, ymin, (u-ymax)/c, ymax)  ;
               u += du ;
          } 




          fTeXlabel(xmin-2, -c*xmin, "cr", "$x+c\\,t=0$") ;
          fTeXlabel(xmin-2, du-c*xmin, "cr", "$x+c\\,t=1$") ;
          fTeXlabel(xmin-2, -du-c*xmin, "cr", "$x+c\\,t=-1$") ;
          fTeXlabel(xmin-2, -2*du-c*xmin, "cr", "$x+c\\,t=-2$") ;
          fTeXlabel(xmin-2, -3*du-c*xmin, "cr", "$x+c\\,t=-3$") ;
          fTeXlabel(xmax+2, 2*du-c*xmax, "cl", "$x+c\\,t=2$") ;
          fTeXlabel(xmax+2, 3*du-c*xmax, "cl", "$x+c\\,t=3$") ;
          
          
     }
}

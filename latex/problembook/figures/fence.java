                  /*  File:  fence.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class fence extends Template {

     static {templateClass = new fence() ; }

     public void setup() {
          filePrefix = "fence" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2*1.3 ;      // in inches
          ysize = 1*1.3 ;   // in inches. 
          xmin = -50 ;
          xmax = 50 ;
          ymin = -45 ;
          ymax = 5 ;
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
          double x = 30 ;
          double th = 60 ;
          double costh = Math.cos(th*Math.PI/180) ;
          double sinth = Math.sin(th*Math.PI/180) ;
          fLine(-50,0, 50,0) ;
          fLine(50-x+15,-x*sinth,-50+x-15,-x*sinth) ;
          fLine(44,-x*sinth,50,-x*sinth) ;
          fArrow(47,-x*sinth/2-4, 47,-x*sinth) ;
          fArrow(47,-x*sinth/2+3, 47,0) ;
          fTeXlabel(47,-x*sinth/2, "cc", "$x\\sin\\theta$") ;
          fEllipticalArc(50-x,-x*sinth, 8, 8, 0, th, OPEN) ;
          fEllipticalArc(-50+x,-x*sinth, 8, 8, 180-th, 180, OPEN) ;


          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          fLine(50-x,-x*sinth, 50-x+x*costh,0) ;
          fLine(50-x,-x*sinth, -50+x,-x*sinth) ;
          fLine(-50+x,-x*sinth, -50+x-x*costh,0) ;
          fTeXlabel(-50+x-x*costh/2+2,-x*sinth/2, "bl", "$x$") ;
          fTeXlabel(50-x+x*costh/2-1,-x*sinth/2, "br", "$x$") ;
          fTeXlabel(0,-x*sinth-2, "tc", "$100-2x$") ;
          fTeXlabel(50-x+8,-x*sinth+3, "bl", "$\\theta$") ;
          fTeXlabel(-50+x-8,-x*sinth+3, "br", "$\\theta$") ;
          
          
     }
}

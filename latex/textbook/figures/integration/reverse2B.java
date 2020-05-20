                  /*  File:  reverse2B.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class reverse2B extends Template {

     static {templateClass = new reverse2B() ; }

     public void setup() {
          filePrefix = "reverse2B" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.2 ;   
          ysize = 1.2 ;   
          xmin = -0.1  ;
          xmax = 1.3 ;
          ymin = -0.1 ;
          ymax = 1.3 ;
          topmargin = 0.0 ;
          bottommargin = 0 ;
          leftmargin = 0.0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.9) ;
          { 
            double[] xlist = { 0, 1, 1} ;
            double[] ylist = { 0, 0, 1} ;
            fPolygon(xlist, ylist, 3, FILLED) ;
           }             
          fLine(xmin, ymin, xmax, ymax) ;
          fLine( 1, ymin, 1, ymax) ;

          fLine( xmin, 0, xmax,0) ;
          fLine( 0, ymin, 0, ymax) ;
    

          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 2.0) ;
          { 
            double[] xlist = { 0, 1, 1} ;
            double[] ylist = { 0, 0, 1} ;
            fPolygon(xlist, ylist, 3, CLOSED) ;
           }             

          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Blue) ;
          double r = 0.05 ;
          fDisk(1,1,r,r,FILLED) ;
          fTeXlabel(1.05, 1.05, "tl", "$(1,1)$") ;
          fEnv("useColorPs", "false") ;


          double xl = 0.4 ;  double xr = 1.0 ; 
          double yt = 0.47 ;  double yb = 0.33 ;
          double xsl = 0.63 ;  double xsr = 0.77 ;


          fEnv("psFillGray", 0.7) ;
          { 
            double[] xlist = { xl, xl, xr, xr} ;
            double[] ylist = { yt, yb, yb, yt} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             
          fEnv("psFillGray", 0.3) ;
          { 
            double[] xlist = { xsl,  xsl,  xsr,  xsr} ;
            double[] ylist = { yt, yb, yb, yt} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             


          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("[2.5 2.5] 0 setdash\n")) ;
          fLine(xsr, yb, xsr, -0.1) ;
          fLine(xsl, yb, xsl, -0.1) ;
          fTeXlabel(0.5*xsr+0.5*xsl, -0.15, "ct", "$\\scriptstyle\\dee{x}$") ;
          fLine(xr, yt, 1.2 , yt) ;
          fLine(xr, yb, 1.2 , yb) ;
          fTeXlabel(1.22, 0.5*yb+0.5*yt, "cl", "$\\scriptstyle\\dee{y}$") ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;


          fTeXlabel(xmax, -0.04, "tr", "$x$") ;
          fTeXlabel(-0.02, ymax, "tr", "$y$") ;
          fTeXlabel(xmax+0.02, ymax,"lt", "$x=y$") ;
          fTeXlabel(0.98, ymax,"rt", "$x=1$") ;

     }
}

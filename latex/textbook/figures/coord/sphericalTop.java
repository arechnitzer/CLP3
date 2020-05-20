                  /*  File:  sphericalTop.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class sphericalTop extends Template {

     static {templateClass = new sphericalTop() ; }

     public void setup() {
          filePrefix = "sphericalTop" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;   
          ysize = 1.5 ;   
          xmin = -0.1  ;
          xmax = 0.9 ;
          ymin = -0.9 ;
          ymax = 0.1 ;
          topmargin = 0.0 ;
          bottommargin = 0.0 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;

          double th = 40 ;
          double thRad = th*Math.PI/180.0 ; 
          double R=0.2 ;
          double r = 0.023 ;
          double x = Math.cos(thRad) ; double y = -Math.sin(thRad) ;
          fEnv("lineWidth", 0.5) ;
          fLine(0, 0, xmax,0) ;
          fTeXlabel(xmax, -0.03, "tr", "$y$") ;
          fLine(0, ymin, 0,0) ;
          fTeXlabel(-0.015, ymin, "br", "$x$") ;

          canvas.append( new fPsWrite("[3 3] 1.4 setdash\n")) ;
          fDisk(0, y, r, r, FILLED) ;
          fLine(0, y, x, y) ;
          fTeXlabel(-0.03, y, "cr", "$(x,0,0)$") ;
          fTeXlabel(x/2, ymin-0.05, "tc", "top view") ;
          fTeXlabel(x/2, y-0.03, "tc", "$\\rho\\sin\\varphi\\sin\\theta$") ;
          fTeXlabel(-0.02, y/2-0.1, "cr", "$\\rho\\sin\\varphi\\cos\\theta$") ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(0, 0, x, y) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fTeXlabel(x/2+0.05, y/2+0.03, "lc", "$\\rho\\sin\\varphi$") ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fEllipticalArc(0, 0, R, R, -90, -th, OPEN) ;
          fTeXlabel(0.1, -R, "ct", "$\\theta$") ;



          fEnv("lineWidth", 1.0) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
//          fLine(0, 0, x, y) ;
          fDisk(x, y, r, r, FILLED) ;
          fTeXlabel(x+0.02, y+0.02, "bl", "$(x,y,0)$") ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          canvas.append( new fPsWrite("[3 3] 1.4 setdash\n")) ;



     }
}

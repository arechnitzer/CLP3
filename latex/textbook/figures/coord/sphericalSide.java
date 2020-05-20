                  /*  File:  sphericalSide.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class sphericalSide extends Template {

     static {templateClass = new sphericalSide() ; }

     public void setup() {
          filePrefix = "sphericalSide" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;   
          ysize = 1.5 ;   
          xmin = -0.1  ;
          xmax = 0.9 ;
          ymin = -0.1 ;
          ymax = 0.9 ;
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

          double th = 45 ;
          double thRad = th*Math.PI/180.0 ; 
          double R=0.2 ;
          double r = 0.023 ;
          double x = Math.cos(thRad) ; double y = Math.sin(thRad) ;
          fEnv("lineWidth", 0.5) ;
          fLine(0, ymin,0, ymax) ;
          fTeXlabel(-0.015, ymax, "tr", "$z$") ;
          canvas.append( new fPsWrite("[3 3] 1.4 setdash\n")) ;
          fDisk(0, y, r, r, FILLED) ;
          fTeXlabel(-0.03, y, "cr", "$(0,0,z)$") ;
          fTeXlabel(-0.02, y/2+0.05, "cr", "$\\rho\\cos\\varphi$") ;
          fDisk(x, 0, r, r, FILLED) ;
          fTeXlabel(x+0.03, 0, "cl", "$(x,y,0)$") ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(0, 0, x, 0) ;
          fTeXlabel(x/2, -0.18, "tc", "side view") ;
          fLine(0, y, x, y) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fTeXlabel(x/2, y+0.03, "bc", "$\\rho\\sin\\varphi$") ;
          fLine(x, 0, x, y) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fEllipticalArc(0, 0, R, R, th, 90, OPEN) ;
          fTeXlabel(0.1, R, "cb", "$\\varphi$") ;



          fEnv("lineWidth", 1.0) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fLine(0, 0, x, y) ;
          fDisk(x, y, r, r, FILLED) ;
          fTeXlabel(x/2+0.02, y/2-0.02, "tc", "$\\rho$") ;
          fTeXlabel(x+0.02, y+0.02, "bl", "$(x,y,z)$") ;

          canvas.append( new fPsWrite(Black+"\n")) ;


     }
}

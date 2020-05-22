                  /*  File:  OE14D_8AA.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE14D_8AA extends Template {

     static {templateClass = new OE14D_8AA() ; }

     public void setup() {
          filePrefix = "OE14D_8AA" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -1.2 ;
          xmax = 0.2 ;
          ymin = -1.2 ;
          ymax = 0.2 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("psFillGray", 0.8) ;
          fEllipticalArc(0,0,1,1,180,270, WEDGE+FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax+0.03, 0.0, "cl", "$x$") ;
          fTeXlabel(0.0, ymax+0.03, "bc", "$y$") ;

          fEllipticalArc(0,0,1,1, 0,360, OPEN) ;

          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEllipticalArc(0,0,1,1,180,270, OPEN) ;
          fLine(0, 0, -1, 0) ;
          fLine(0, 0,  0, -1) ;

          double x = -0.3 ;  double y = -Math.sqrt(1-x*x) ;
          double yy = -0.3 ; double w = 0.05 ;
          fEnv("lineWidth",8.0) ;
          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          fLine(x,0, x,y) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          fLine(x,yy-w, x,yy+w) ;

          fTeXlabel(-0.9, -0.5, "tr", "$x^2+y^2=a^2$") ;
    


          fEnv("psFillGray", 0.0) ;
          double r = 0.04 ;
          fDisk(-1, 0, r, r, FILLED) ;
          fTeXlabel(-1.03, 0.05, "br", "$\\scriptstyle (-a,0)$") ;
          

     }
}

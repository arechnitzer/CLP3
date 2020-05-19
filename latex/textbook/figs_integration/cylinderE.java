                  /*  File:  cylinderE.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class cylinderE extends Template {

     static {templateClass = new cylinderE() ; }

     public void setup() {
          filePrefix = "cylinderE" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;   
          ysize = 1.5 ;   
          xmin = -1  ;
          xmax = 5 ;
          ymin = -5 ;
          ymax = 1 ;
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
          double rx = 4 ; double ry = 4 ;
          fEnv("psFillGray", 0.9) ;
          fEllipticalArc(0,0, rx, ry, -90, 0, FILLED) ;
          { 
            double sq2 = Math.sqrt(2) ;
            double[] xlist = { 0, ry, ry/sq2, 0} ;
            double[] ylist = { 0,  0, -rx/sq2, -rx} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             


          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("lineWidth", 1.5) ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEllipticalArc(0,0, rx, ry, -90, 0, OPEN) ;
          canvas.append( new fPsWrite(Black+"\n")) ;

          fEnv("lineWidth", 12.0) ;
          canvas.append( new fPsWrite("0.7 setgray\n")) ;
          double y = 1.5 ;
          fLine(0, -y, rx*Math.sqrt(1-y*y/ry/ry), -y) ;
          canvas.append( new fPsWrite("0.5 setgray\n")) ;
          double xsl = 1.0 ;  double xsr = 1.7 ;  
          fLine(xsl, -y, xsr, -y) ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;


          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("[2.0 2.0] 0 setdash\n")) ;
          fLine( xsl,  -y, xsl , ymax) ;
          fLine( xsr,  -y, xsr , ymax) ;
          double dy = 0.3 ;
          fLine( 0, -y+dy, xmin,  -y+dy) ;
          fLine( 0, -y-dy, xmin,  -y-dy) ;
          fLine(0,  -ry , 0.6*xmin, -ry) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;


          fTeXlabel(xmax+0.1, 0.0, "cl", "$y$") ;
          fTeXlabel(0.0, ymin-0.25, "ct", "$x$") ;
          fTeXlabel(ry/2.0, ymin+0.4, "ct", "top view") ;
          fTeXlabel(xmin, -y, "cl", "$\\scriptstyle\\dee{x}$") ;
          fTeXlabel(0.5*(xsl+xsr), ymax, "tc", "$\\scriptstyle\\dee{y}$") ;
          fTeXlabel( 0.65*xmin,  -ry, "cr", "$x = a$") ;
//          fTeXlabel(rx, -1, "tl", "$x^2+y^2=a^2$") ;
          fTeXlabel(rx-0.3, -1.7, "tl", "$y=\\sqrt{a^2-x^2}$") ;

     }
}

                  /*  File:  PSIVcb.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class PSIVcb extends Template {

     static {templateClass = new PSIVcb() ; }

     public void setup() {
          filePrefix = "PSIVcb" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.2 ;      // in inches
          ysize = 1.2 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -0.2 ;
          xmax = 2.3 ;
          ymin = -0.2 ;
          ymax = 2.3 ;
          topmargin = 0.1 ;   // in inches
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
          { double[] xlist = { 0, 0, 2, 2} ;
            double[] ylist = {  0, 2, 2, 0} ;
            fPolygon(xlist, ylist, 4, FILLED) ; }
          fEnv("psFillGray", 1.0) ;
//          fDisk(0, 0, 1, 1, FILLED) ;
          fEnv("psFillGray", 0.0) ;
          fEllipticalArc(0, 0, 1, 1, 0, 90, OPEN) ;
          { double[] xlist = { 0, 0, 2, 2} ;
            double[] ylist = { 0, 2, 2, 0} ;
            fPolygon(xlist, ylist, 4, CLOSED) ; }
          fDisk(0, 0, 0.05, 0.05, FILLED) ;
          fDisk(0, 1, 0.05, 0.05, FILLED) ;
          fDisk(0, 2, 0.05, 0.05, FILLED) ;
          fDisk(2, 2, 0.05, 0.05, FILLED) ;
          fDisk(2, 0, 0.05, 0.05, FILLED) ;
          fDisk(1, 0, 0.05, 0.05, FILLED) ;
          fEnv("lineWidth", 0.2) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(2.05, 2.05, "bl", "$(2,2)$") ;
          fTeXlabel(-0.05, -0.05, "tr", "$(0,0)$") ;
          fTeXlabel(-0.1, 2, "rc", "$2$") ;
          fTeXlabel(-0.1, 1, "rc", "$1$") ;
          fTeXlabel(2, -0.1, "tc", "$2$") ;
          fTeXlabel(1, -0.1, "tc", "$1$") ;
          fTeXlabel(-0.1, 2, "rc", "$2$") ;
          fTeXlabel(1.2, 1.2, "cc", "$\\cR_1$") ;
          fTeXlabel(0.4, 0.4, "cc", "$\\cR_2$") ;
          
//          fArrow(-0.2, 0.2, Math.cos(Math.PI/3), Math.sin(Math.PI/3)) ;
//          fTeXlabel(-0.2, 0.24, "rt", "${{\\rm quarter}\\atop {\\rm circle}}$") ;

          
     }
}

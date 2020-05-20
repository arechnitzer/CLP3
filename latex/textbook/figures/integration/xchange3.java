                  /*  File:  xchange3.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class xchange3 extends Template {

     static {templateClass = new xchange3() ; }

     public void setup() {
          filePrefix = "xchange3" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.4*1.2 ;    
          ysize = 1.4*1.2 ;  
          xmin = -0.2 ;
          xmax =  2.2 ;
          ymin = -1.2 ;
          ymax =  0.2 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double z = 1.0 ;
          double rr = 0.03 ; 

          {fEnv("psFillGray", 0.9) ;
           double[] xlist = {0, 0, 2-z, 2-z} ;
           double[] ylist = {0,-1,-z/2, 0} ;
           fPolygon(xlist, ylist, 4, FILLED) ;
           }

          fEnv("lineWidth", 0.5) ;
          fLine(2,ymin,2,ymax) ;
          fLine(2-z,ymin,2-z,ymax) ;
          fLine(xmin, 0.5*(xmin-2), xmax, 0.5*(xmax-2)) ;

          fLine(xmin,0,xmax,0) ;
          fLine(0,ymin,0,ymax) ;
          fTeXlabel(xmax+0.05,0, "lc", "$y$") ;
          fTeXlabel(0,ymin-0.05, "tc", "$x$") ;
          fArrow(1.3, -1.3, 1-z+0.03, -1.3) ;
          fTeXlabel(2,ymin, "tc", "$y=2$") ;
          double x=0.2 ;
          fTeXlabel(x,0.5*(x-2)-0.03, "tl", "$2x+y=2$") ;
          fTeXlabel(2-z+0.1,ymin, "tc", "$y=2-Z$") ;

          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Black = "0 0 0 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 2.0) ;
          {double[] xlist = {0, 0, 2-z, 2-z} ;
           double[] ylist = {0,-1,-z/2, 0} ;
           fPolygon(xlist, ylist, 4, CLOSED) ;
           }
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillGray", 0.0) ;
          fDisk(0,-1, rr, rr, FILLED) ;
          fTeXlabel(-0.03,-1, "br", "$(1,0)$") ;
          fDisk(2-z,-z/2, rr, rr, FILLED) ;
          fTeXlabel(2-z+0.03,-z/2, "tl", "$(Z/2,2-Z)$") ;
          fDisk(2-z, 0, rr, rr, FILLED) ;
          fTeXlabel(2-z+0.03, 0.02, "bl", "$(0,2-Z)$") ;

          
     }
}


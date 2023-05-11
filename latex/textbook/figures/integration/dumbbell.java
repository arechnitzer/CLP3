                  /*  File:  dumbbell.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class dumbbell extends Template {

     static {templateClass = new dumbbell() ; }

     public void setup() {
          filePrefix = "dumbbell" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4*0.6 ;   
          ysize = 2*0.6 ;   
          xmin = -0.2  ;
          xmax = 3.8 ;
          ymin = -1.0 ;
          ymax = 1.0 ;
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
          fEnv("lineWidth", 2.0) ;
          fEnv("psFillGray", 0.9) ;
          fLine(1,0, 3, 0.5) ;
          fDisk(1,0,0.8,0.8*aspect,FILLED+CLOSED) ;
          fDisk(3,0.5,0.7,0.3*aspect,FILLED+CLOSED) ;

//          String Red = "0 1 1 0 setcmykcolor  " ;
//          canvas.append( new fPsWrite(Red+"\n")) ;
//          fEnv("useColorPs", "true") ;
//          fEnv("psFillColor", Red) ;


          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("[2.5 2.5] 0 setdash\n")) ;
          { 
            double[] xlist = { 0,  0,  3.8, 3.8} ;
            double[] ylist = { -1, 1, 1, -1} ;
            fPolygon(xlist, ylist, 4, CLOSED) ;
           }             

          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;

          fTeXlabel(3, -0.3, "cc", "$\\cR$") ;
          fTeXlabel(1, 0, "cc", "$\\cR_1$") ;
          fTeXlabel(3, 0.5, "cc", "$\\cR_2$") ;

     }
}

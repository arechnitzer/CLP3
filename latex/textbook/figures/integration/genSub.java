                  /*  File:  genSub.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class genSub extends Template {

     static {templateClass = new genSub() ; }

     public void setup() {
          filePrefix = "genSub" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.2*0.8 ;      // in inches
          ysize = 4.2*0.5 ;   // in inches. 
          xmin = -0.2 ;
          xmax = 2 ;
          ymin = -0.2 ;
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

          fEnv("psFillGray", 0.9) ;
          { 
            double[] xlist = { 0, 0, 1, 1} ;
            double[] ylist = { 1, 2, 4, 2} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }     

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1 , "tr", "$x$") ;
          fTeXlabel(-0.05, ymax , "tr", "$y$") ;
          fLine(xmin, 1+xmin, xmax, 1+xmax) ;
          fLine(xmin, 2+2*xmin, xmax, 2+2*xmax) ;
          fLine(1, ymin, 1, ymax) ;
        


          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;
          fEnv("lineWidth", 1.5) ;

          { 
            double[] xlist = { 0, 0, 1, 1} ;
            double[] ylist = { 1, 2, 4, 2} ;
            fPolygon(xlist, ylist, 4, CLOSED) ;
           }             

          fTeXlabel(0.4, 3.5 , "bc", "$\\scriptstyle y=2(1+x)$") ;
          fTeXlabel(0.6, 1.3 , "tc", "$\\scriptstyle y=1+x$") ;
          fTeXlabel(1+0.05, 3 , "cl", "$x=1$") ;
          fTeXlabel(0-0.05, 1.3 , "cr", "$x=0$") ;
          fTeXlabel(0.5, 2.25 , "cc", "$\\cR$") ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("useColorPs", "false") ;


     }
}

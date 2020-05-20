                  /*  File:  OE09D_6v.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE09D_6v extends Template {

     static {templateClass = new OE09D_6v() ; }

     public void setup() {
          filePrefix = "OE09D_6v" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.4*1.0 ;      // in inches
          ysize = 1.4*1.0 ;   // in inches. 
          xmin = -0.1 ;
          xmax = 2.3 ;
          ymin = -0.1 ;
          ymax = 1.3 ;
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
         { 
            double[] xlist = { 0, 2,  1,} ;
            double[] ylist = { 0, 0,  1} ;
            fPolygon(xlist, ylist, 3, FILLED) ;
           }             

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;

          fLine(xmin,xmin, xmax,xmax) ;
          fLine(2,0, 2-ymax,ymax) ;
          fTeXlabel(1.4,0.7, "cl", "$y=2-x$") ;
          fTeXlabel(0.6,0.7, "cr", "$y=x$") ;

          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
          fLine(1,ymax, 1,ymin) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;
          fTeXlabel(1,ymin, "ct", "$x=1$") ;



          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
         { 
            double[] xlist = { 0, 2,  1,} ;
            double[] ylist = { 0, 0,  1} ;
            fPolygon(xlist, ylist, 3, CLOSED) ;
           }             


          fEnv("psFillGray", 0.0) ;
          double r = 0.03 ;
          fDisk(1, 1, r, r, FILLED) ;
          fTeXlabel(1.05, 1.0, "cl", "$\\scriptstyle (1,1)$") ;
          fDisk(2, 0, r, r, FILLED) ;
          fTeXlabel(2.0, -0.05, "ct", "$\\scriptstyle (2,0)$") ;

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double X = 0.7 ;
          double YB = 0 ;
          double YT = X ;
          fEnv("lineWidth", 8.0) ;
          fLine(X,YB, X,YT) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          YB = 0.3 ;
          YT = 0.4 ;
          fLine(X,YB, X,YT) ;          

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          X = 1.3 ;
          YB = 0 ;
          YT = 2-X ;
          fLine(X,YB, X,YT) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          YB = 0.3 ;
          YT = 0.4 ;
          fLine(X,YB, X,YT) ;          
     }
}

                  /*  File:  OE08A_8xv.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE08A_8xv extends Template {

     static {templateClass = new OE08A_8xv() ; }

     public void setup() {
          filePrefix = "OE08A_8xv" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.4*1.5 ;      // in inches
          ysize = 1.4*1.5 ;   // in inches. 
          xmin = -0.2 ;
          xmax = 1.2 ;
          ymin = -0.2 ;
          ymax = 1.2 ;
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
           double X = 0.1 ; double Y = Math.sqrt(X) ;
          fEnv("psFillGray", 0.9) ;
          { 
            double[] xlist = { Y, 1,      Y,} ;
            double[] ylist = { 0, 0,   1-Y } ;
            fPolygon(xlist, ylist, 3, FILLED) ;
           }         


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax+0.03, 0, "cl", "$y$") ;
          fTeXlabel(0, ymax+0.03, "cb", "$z$") ;

          fLine(Y,ymin,  Y, ymax) ;
          fLine(1,ymin,  1, ymax) ;
          fLine(xmin,1-xmin,  xmax, 1-xmax) ;
          fTeXlabel(1-ymax-0.03, ymax, "cr", "$z=1-y$") ;
          fTeXlabel(Y, ymax+0.03, "cb", "$y=\\sqrt{x}$") ;
          fTeXlabel(1, ymax+0.03, "cb", "$y=1$") ;

          fEnv("psFillGray", 0.0) ;
          double r = 0.03 ;
          fDisk(Y, 1-Y, r, r, FILLED) ;
          fArrow(xmax,1-Y, Y+0.04, 1-Y) ;
//          fTeXlabel(xmin-0.03, 1-Y, "cr", "$y=\\sqrt{x},\\ z=1-\\sqrt{x}$") ;



          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          { 
            double[] xlist = { Y, 1,      Y,} ;
            double[] ylist = { 0, 0,   1-Y } ;
            fPolygon(xlist, ylist, 3, CLOSED) ;
           }   



          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double XS = 0.5 ;
          double YB = 0 ;
          double YT = 1-XS ;
          fEnv("lineWidth", 7.0) ;
          fLine(XS,YB, XS,YT) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          YB = 0.2 ;
          YT = 0.27 ;
          fLine(XS,YB, XS,YT) ;  
     }
}

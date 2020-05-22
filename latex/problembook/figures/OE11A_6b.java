                  /*  File:  OE11A_6b.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE11A_6b extends Template {

     static {templateClass = new OE11A_6b() ; }

     public void setup() {
          filePrefix = "OE11A_6b" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.6 ;      // in inches
          ysize = 1.6 ;   // in inches. 
          xmin = -0.1 ;
          xmax = 2.5 ;
          ymin = -0.1 ;
          ymax = 1.5 ;
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
          fEnv("psFillGray", 0.9) ;
          double sq2 = Math.sqrt(2) ;
//          { 
//            double[] xlist = { 0, sq2,  2} ;
//            double[] ylist = { 0, sq2,  0} ;
//            fPolygon(xlist, ylist, 3, FILLED) ;
//           }             
          fEllipticalArc(0,0, 2,2, 0,45, WEDGE+FILLED) ;
          fEnv("psFillGray", 1.0) ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

          fEllipticalArc(0,0, 2,2, -10,100, OPEN)  ;
          fLine(xmin, xmin, xmax, xmax) ;
//          fTeXlabel(1.9, 0.8, "cl", "$\\scriptstyle x=\\sqrt{4-y^2}$") ;
//          fTeXlabel(sq2/2-0.1, sq2/2, "br", "$\\scriptstyle x=y$") ;
          fTeXlabel(1.9, 0.8, "cl", "$y=\\sqrt{4-x^2}$") ;
          fTeXlabel(0.7*sq2-0.05, 0.7*sq2, "br", "$y=x$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEllipticalArc(0,0, 2,2, 0,45, OPEN) ;
          fLine(0,0, sq2,sq2) ;
          fLine(0,0, 2,0) ;

          fEnv("psFillGray", 0.0) ;
          double r = 0.03 ;
          fDisk(sq2, sq2, r, r, FILLED) ;
          fDisk(2, 0, r, r, FILLED) ;
          fTeXlabel(sq2+0.1, sq2, "cl", "$\\scriptstyle (\\sqrt{2},\\sqrt{2})$") ;
          fTeXlabel(2.05,0.05, "bl", "$\\scriptstyle (2,0)$") ;

          fEnv("lineWidth",0.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
               fLine(sq2,xmax, sq2,xmin) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;




          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double X = 1.0 ;
          double YT = X ;
          double YB = 0 ;
          fEnv("lineWidth", 10.0) ;
          fLine(X,YB, X,YT) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          YB = 0.4 ;
          YT = 0.55 ;
          fLine(X,YB, X,YT) ;

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          X = 0.5*sq2+0.5*2 ;
          YT = Math.sqrt(4-X*X) ;
          YB = 0 ;
          fLine(X,YB, X,YT) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          YB = 0.4 ;
          YT = 0.55 ;
          fLine(X,YB, X,YT) ;


          
     }
}

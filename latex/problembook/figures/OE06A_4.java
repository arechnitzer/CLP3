                  /*  File:  OE06A_4.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE06A_4 extends Template {

     static {templateClass = new OE06A_4() ; }

     public void setup() {
          filePrefix = "OE06A_4" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.6*0.6 ;      // in inches
          ysize = 2.6*0.6 ;   // in inches. 
          xmin = -1.3 ;
          xmax = 1.3 ;
          ymin = -1.3 ;
          ymax =  1.3 ;
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
          double x = 0.7 ; double y = Math.sqrt(1-x*x) ;
          { 
            double[] xlist = {x, -x, -x,  x} ;
            double[] ylist = {y,  y, -y, -y} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$z$") ;

          fEnv("lineWidth", 1.0) ;
          fDisk(0,0, 1,1, CLOSED) ;



          fTeXlabel(-x, -y, "tr", "$x^2+y^2+z^2=1$") ;

          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          { 
            double[] xlist = {x, -x, -x,  x} ;
            double[] ylist = {y,  y, -y, -y} ;
            fPolygon(xlist, ylist, 4, CLOSED) ;
           }             

          double r = 0.05 ;
          fEnv("psFillGray", 0.0) ;
          fDisk(x,y, r,r, FILLED) ;
          fTeXlabel(x+0.03, y+0.03, "lb", 
                 "$\\scriptstyle (r\\,,\\,0\\,,\\,h/2)$") ;
          fDisk(x,-y, r,r, FILLED) ;
          fTeXlabel(x+0.03, -y-0.03, "lt", 
                 "$\\scriptstyle (r\\,,\\,0\\,,\\,-h/2)$") ;

          
     }
}

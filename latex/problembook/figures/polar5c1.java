                  /*  File:  polar5c1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polar5c1 extends Template {

     static {templateClass = new polar5c1() ; }

     public void setup() {
          filePrefix = "polar5c1" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.6*0.5 ;      // in inches
          ysize = 2.6*0.5 ;   // in inches. 
          xmin = -0.2 ;
          xmax =  2.4 ;
          ymin = -0.2 ;
          ymax =  2.4 ;
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
          { 
            double[] xlist = { 0, 2, 0} ;
            double[] ylist = { 0, 2, 2} ;
            fPolygon(xlist, ylist, 3, FILLED) ;
           }        


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;
          fLine(0,0, xmax, xmax) ;
          fLine(0,2, xmax, 2) ;


          fTeXlabel(xmax+0.05, xmax, "cl", "$y=x$") ;
          fTeXlabel(xmax+0.05, 2, "cl", "$y=2$") ;
          double thRad = 67.5*Math.PI/180 ;
          double x = (1+0.5)*Math.cos(thRad) ; 
          double y = (1+0.5)*Math.sin(thRad) ; 
          fTeXlabel(x, y, "cc", "$\\cR$") ;

             
          fEnv("lineWidth",1.5) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          { 
            double[] xlist = { 0, 2, 0} ;
            double[] ylist = { 0, 2, 2} ;
            fPolygon(xlist, ylist, 3, CLOSED) ;
           }   

          
     }
}

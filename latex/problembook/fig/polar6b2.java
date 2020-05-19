                  /*  File:  polar6b2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polar6b2 extends Template {

     static {templateClass = new polar6b2() ; }

     public void setup() {
          filePrefix = "polar6b2" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.6*0.8 ;      // in inches
          ysize = 1.6*0.8 ;   // in inches. 
          xmin = -0.2 ;
          xmax =  2.4 ;
          ymin = -0.2 ;
          ymax =  1.4 ;
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
            double[] xlist = { 0, 1, 2} ;
            double[] ylist = { 0, 1, 0} ;
            fPolygon(xlist, ylist, 3, FILLED) ;
           }      
//          double th = 25 ; double thRad = th*Math.PI/180 ;
//          double dth = 7 ;  double dthRad = dth*Math.PI/180 ;
//          double rrr = 2/(Math.sin(thRad+dthRad)+Math.cos(thRad+dthRad)) ;  
//              double xxx = rrr*Math.cos(thRad+dthRad) ;  
//              double yyy = rrr*Math.sin(thRad+dthRad) ;  
//          double rr = 2/(Math.sin(thRad)+Math.cos(thRad)) ;  
//              double xx = rr*Math.cos(thRad) ;  
//              double yy = rr*Math.sin(thRad) ;  
//          fEnv("psFillGray", 0.6) ;
//          { 
//            double[] xlist = { 0, xx, xxx} ;
//            double[] ylist = { 0, yy, yyy} ;
//            fPolygon(xlist, ylist, 3, FILLED) ;
//           } 
//          fEnv("psFillGray", 0.3) ;
//          double r1 = 0.75*rr ;
//          double r2 = 0.65*rr ;
//          fEllipticalArc(0,0, r1, r1, th,th+dth, WEDGE+FILLED) ;
//          fEnv("psFillGray", 0.6) ;
//          fEllipticalArc(0,0, r2, r2, th,th+dth, WEDGE+FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;
          fLine(0,0, xmax, xmax) ;
          fLine(2,0, 2-ymax, ymax) ;


//          fTeXlabel(ymax+0.05, ymax+0.05, "bl", "$y=x$") ;
          fTeXlabel(0.7, 0.7, "br", "$y=x$") ;
//          fTeXlabel(2-ymax, ymax+0.02, "bc", "$y=2-x$") ;
          fTeXlabel(1.35, 0.7, "bl", "$y=2-x$") ;


             
          fEnv("lineWidth",1.5) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          { 
            double[] xlist = { 0, 1, 2} ;
            double[] ylist = { 0, 1, 0} ;
            fPolygon(xlist, ylist, 3, CLOSED) ;
           }   

          
     }
}

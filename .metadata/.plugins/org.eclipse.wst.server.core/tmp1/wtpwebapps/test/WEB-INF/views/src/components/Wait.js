import React from 'react';
import './Wait.css'
const Wait = () =>{
   return( 
    <div id="waitDiv">
    
        <div className="ui active inverted dimmer">
            <div className="ui large text loader">Waiting Response from your Tender
                <div className="ui icon header" id="bomtDiv">
                    <i className="search plus icon"></i>
                    Get another Tender                        
                </div>
                
            </div>            
        </div>
        
    </div>
   )
}

export default Wait;
import React from 'react';
import './Total.css'
import Match from './Match';
import Profile from './Profile';
import MyProfile from './MyProfile';

class Total extends React.Component{
   state= {
       bigScreen: 'Match'  // 현재 보여줄 페이지를 뜻함
   }
    MyProfileClick = (e) =>{    
        console.log('noew bigscreen =',this.state.bigScreen)
       if(this.state.bigScreen==='Match'){
        this.setState({bigScreen:'MyProfile'})
       }else if(this.state.bigScreen==='MyProfile'){
        this.setState({bigScreen:'Match'})         
       }
    }  
    
    render(){
       // const myProfile = document.querySelector("#myProfile");
       // const bigScreen = document.querySelector("#bigScreen");
       

        let bigScreen = <Match/>;   //어떤걸 빅스크린에 보여줄지
        let ButtonLabel = 'MyProfile';
        if(this.state.bigScreen==='Match'){
            bigScreen =  <Match/>;     
            ButtonLabel = 'MyProfile';
        }else if(this.state.bigScreen==='MyProfile'){
            bigScreen = <MyProfile/>;
            ButtonLabel = 'Match';
        }
        console.log("Buttonlabel=",ButtonLabel)
        return(
            <div className="ui grid">
                <div id="edit" className="five wide column">                    
                    <Profile ButtonLabel={ButtonLabel} MyProfileClick={this.MyProfileClick}/>
                </div>
                <div className="eleven wide column" id="bigScreen">
                {/* match or myprofile */}
                    {bigScreen}               
                </div>

            </div>
           
        );
    }
}

export default Total;
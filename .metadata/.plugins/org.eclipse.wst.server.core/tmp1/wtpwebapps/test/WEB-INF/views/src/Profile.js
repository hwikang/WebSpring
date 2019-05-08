import React from 'react';
import './Profile.css';
import { withStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import Typography from '@material-ui/core/Typography';



    function TabContainer(props) {
        console.log("props=",props)
        return (
        <Typography component="div" style={{ padding: 8 * 3 }}>
            {props.children}
        </Typography>
        );
    }

class Profile extends React.Component{
    state = {
        value: 0,
    };

    changeTab = (e) =>{
        let activeTab = document.querySelector('.item.active');
        activeTab.classList.remove('active');// 이전꺼 액티브지우고
       // let content = document.querySelector('.segment.active');
       // content.classList.remove('active');        
        console.log(e.target.classList);
        e.target.classList.add('active'); //눌린놈 액티브 추가
    }

    handleChange = (event, value) => {
        this.setState({ value });
        console.log("value=",value)
      };

    
    render(){
        //const { classes } = this.props;
        //console.log("classes=",classes)
        const { value } = this.state;
        return (
            <div>

                
                <header id='header' style={{backgroundColor:'#febbbb'}}>
                <div id="myProfileDiv">
                    
                        <img className="ui avatar image" src="/images/2.jpg"></img>
                        <button id="myProfileBtn" onClick={this.props.MyProfileClick}>{this.props.ButtonLabel}</button>
                        <i className="eye icon"></i>
                    </div>
                </header>

                <Paper >
                    <Tabs
                    value={this.state.value}
                    onChange={this.handleChange}
                    indicatorColor="primary"
                    textColor="primary"
                    centered
                    >
                    <Tab label="Item One" />
                    <Tab label="Item Two" />
                    </Tabs>
                    {value === 0 && <TabContainer><div><h1>SSSIBA</h1><p>hahahaha</p></div></TabContainer>}
                    {value === 1 && <TabContainer><div><h1>NANI?</h1><p>SGOI</p></div></TabContainer>}
                </Paper>

               {/* Firstㅇdd
                    <img id= 'img1' className="ui medium circular image" src="/images/2.jpg"/>
                    <span>MATCH Setting</span>
                    <div>최대 거리    150km <br/>
                    ---------------
                    </div>
                    <div>원하는 상대     <input type='button' value='여성'></input></div>
                    <div>연령대        22 -38<br/>
                    --------------------------    
                    </div>
                    <div> 내 정보 Tender 에 등장시키기 <input type='button' value="누르기"></input><br/>
                     이 옵션을 끄면 내 정보가 Tender에 노출되지 않습니다.</div>

                     <span>푸시 알림 </span><br/>
                     <span>연락처</span> */}
               
                
                     {console.log('렌더끝')}
                

            </div>
            
        )

    }   
}
export default Profile;

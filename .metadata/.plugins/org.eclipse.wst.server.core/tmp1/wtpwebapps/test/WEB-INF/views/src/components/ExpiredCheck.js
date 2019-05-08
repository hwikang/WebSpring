import React from 'react';
import PersonDetail from './PersonDetail';
import Wait from './Wait'
class ExpiredCheck extends React.Component{
    state={
        expired:''
    }
 
     checkExpired = () =>{
         console.log('Expired?')
         let nowDate = new Date();
         let expiredData = JSON.parse(localStorage.getItem('Expired')); 
 
         if(nowDate>expiredData['date']){  //현재시각과 만료시각 비교
             expiredData['expired'] = false;
         }
         console.log('expiredData[expired]',expiredData['expired'])
         if(expiredData['expired']===true){
             console.log('Expired true')
             this.setState({expired:true})
         }else{
             this.setState({expired:false})
         }
 
     }
     componentDidMount(){
         if(localStorage.getItem('Expired')!==null){
             this.checkExpired();
         }
     }

     render(){
         let display ='';
        if(this.state.expired===true){
            display= <Wait/>
        }else if(this.state.expired===false ||this.state.expired==='' ){
            display= <PersonDetail name={this.props.name} age={this.props.age} des={this.props.des} img={this.props.img}
            like = {this.props.like} job={this.props.job}/>
        }
        return(
            <div>
                {display}
            </div>
        )
    }
}

export default ExpiredCheck;
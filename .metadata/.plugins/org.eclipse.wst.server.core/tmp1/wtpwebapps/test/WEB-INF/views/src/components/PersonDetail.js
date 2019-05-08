import React from 'react';
import './PersonDetail.css';
import Wait from './Wait'
class PersonDetail extends React.Component{
   state ={
       expired : ''
   }

    render(){
         //ui container two column centered grid
        const like = this.props.like
        console.log('like=',like)

        const createLikeBtn = (likeArr) =>{
            console.log("likearr=",likeArr)
            let likeBtn = '';
            if(likeArr !== null &&likeArr !== ''  ){
                likeBtn = likeArr.map( like => {
                return <button className="ui basic button likeBtn">{like}</button>
            
            });
            console.log(likeBtn)
            }

            return likeBtn
        }
        const clickChoice = (e) =>{
            let expireDate= new Date();
            console.log('now hour = ', expireDate.getHours())
            expireDate.setHours(expireDate.getHours()+1);  //만료기간 설정
            let expireObj = {'expired':true,'date':expireDate}
            localStorage.setItem('Expired',JSON.stringify(expireObj)) //로컬스토리지 저장
            this.setState({
                expired:true
            })
        }
        
        //매칭 기간 만료 true만료됨 / false
        
            return( 
               <div> 
                {this.state.expired?<Wait/> : 
               <div className="ui container two column centered grid" id="cardbody">
               <div className="ui card column">
                   <div className="card ">
                       <div className="content">
                           <div className="header">{this.props.name}</div>
                           <div className="meta">{this.props.age}</div>
                           <div className="meta">{this.props.job}</div>
                       </div>
                       <div className="extra content">
                           <div>
                           
                               {createLikeBtn(this.props.like)}
                           </div>                        
                       </div> 
                       <div className="extra content">
                           <div>
                               <hr/>
                               <div className="description">{this.props.des}</div>
                           </div>                        
                       </div> 
                       
                       <div className="extra content">
                           <div className="ui four buttons">
                               <div className="ui animated fade green button">
                                   <div className="hidden content">Refresh</div>
                                   <div className="visible content">
                                       <i className="redo icon"></i>
                                   </div>                            
                               </div>
                               <div className="ui animated fade blue button" onClick={clickChoice} id="good">
                                   <div className="hidden content" >Good?</div>
                                   <div className="visible content" >
                                       <i className="thumbs up outline icon"></i>
                                   </div>                            
                               </div>
                               <div className="ui animated fade red button"  onClick={clickChoice} id="bad">
                                   <div className="hidden content">Bad!</div>
                                   <div className="visible content">
                                       <i className="thumbs down outline icon"></i>
                                   </div>                            
                               </div>
                               <div className="ui animated fade yellow button">
                                   <div className="hidden content">Scouter</div>
                                   <div className="visible content">
                                       <i className="binoculars icon"></i>
                                   </div>                            
                               </div>
                                                   
                           
                           </div>
                       </div>  
                       
                       <div className="extra content">
                           <div className="image">
                               <img src={this.props.img} alt="userImage" id="profileImage"/>
                           </div>                    
                       </div>   
                       
                   </div>  
               </div>
               </div>
                }
                </div>
           );//RETURN
    }
}

export default PersonDetail;
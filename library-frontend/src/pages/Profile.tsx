import React, {useContext} from 'react';
import { UserType } from "../types";
import AuthContext from "../context/AuthContext";

const Profile: React.FC = () => {
  const authContext = useContext(AuthContext);
  return (
    <div className="max-w-screen-xl mx-auto w-full py-4 flex flex-col items-center mt-auto">
      <h2 className="text-2xl font-medium pb-8">My Profile</h2>
      <div className="stats stats-vertical shadow w-1/2 border-neutral border-2 ">

        <div className="stat flex flex-col items-center border-neutral ">
          <div className="stat-title">Username</div>
          <div className="stat-value text-xl">{authContext.userInfo?.username}</div>
        </div>

        <div className="stat flex flex-col items-center border-neutral ">
          <div className="stat-title">Email</div>
          <div className="stat-value text-xl">{authContext.userInfo?.email}</div>
        </div>

        <div className="stat flex flex-col items-center border-neutral ">
          <div className="stat-title">Account</div>
          <div className="stat-value text-xl">{authContext.userInfo?.account ? authContext.userInfo.account : 250} som</div>
        </div>
        <div className="stat flex flex-col items-center border-neutral ">
          <div className="stat-title">Role</div>
          <div className="stat-value text-xl">{authContext.userInfo?.role.toUpperCase()}</div>
        </div>
      </div>
    </div>
  );
};

export default Profile;

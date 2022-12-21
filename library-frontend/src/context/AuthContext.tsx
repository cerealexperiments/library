import React, {createContext, PropsWithChildren, useState} from "react";
import {RoleType, UserType} from "../types";

type AuthContextType = {
  role: RoleType,
  setRole: any;
  token?: string;
  setToken: any;
  userInfo?: UserType;
  setUserInfo: (userInfo: UserType) => any;
}

const AuthContext = createContext<AuthContextType>({
  role: "none",
  setRole: () => {},
  token: "",
  setToken: () => {},
  userInfo: {
    id: 1,
    role: "none",
    email: "unknown",
    username: "unknown",
    password: "unknown",
    account: 250
  },
  setUserInfo: () => {},
});

export const AuthProvider = ({children}: PropsWithChildren) => {
  const [role, setRole] = useState<RoleType>("none");
  const [token, setToken] = useState<string>("");
  const [userInfo, setUserInfo] = useState<UserType>();

  return (
    <AuthContext.Provider value={{
      role,
      setRole,
      token,
      setToken,
      userInfo,
      setUserInfo
    }}>
      {children}
    </AuthContext.Provider>
  )
}

export default AuthContext;

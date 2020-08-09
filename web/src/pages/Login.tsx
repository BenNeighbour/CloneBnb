import { AppBar, Paper } from "@material-ui/core";
import * as React from "react";
import { RouteComponentProps } from "react-router-dom";

interface Props extends RouteComponentProps<any> {}

const Login: React.FC<Props> = (props) => {
  return (
    <div style={{
      height: "100%"
    }}>
      {/* Navbar Here */}
      <AppBar style={{
        backgroundColor: "white",
        marginBottom: "1vh"
      }}>
        <div
          style={{
            paddingLeft: "80px",
            paddingRight: "80px",
            minHeight: "8vh",
          }}
        >
          <div
            style={{ 
              lineHeight: 1,
              height: "100%",
              paddingTop: "2.66vh",
              paddingBottom: "2.66vh"
            }}
          >
            <h3
              style={{
                color: "#FF385C",
                fontSize: "150%",
                padding: 0
              }}
            >
              <b>CloneBnb</b>
            </h3>
          </div>
        </div>
      </AppBar>

      <div
        style={{
          display: "grid",
          placeItems: "center",
          height: "100vh"
        }}
      >
        <Paper variant="outlined">
          <div style={{
            padding: "20vh"
          }}>

          </div>
        </Paper>
      </div>
    </div>
  );
};

export default Login;

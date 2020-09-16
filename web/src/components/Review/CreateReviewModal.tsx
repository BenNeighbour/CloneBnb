import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import Button from "@material-ui/core/Button";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import DialogTitle from "@material-ui/core/DialogTitle";
import useMediaQuery from "@material-ui/core/useMediaQuery";
import { useTheme } from "@material-ui/core/styles";
import { TextareaAutosize } from "@material-ui/core";

interface Props extends RouteComponentProps<any> {
  handleClose(): void;
  handleSubmit(): void;
  listingName: string;
}

const CreateReviewModal: React.FC<Props> = (props) => {
  const theme = useTheme();
  const fullScreen = useMediaQuery(theme.breakpoints.down("sm"));
  const [currentRating, setCurrentRating]: any = React.useState(1);

  const starClickHandler = (ev: any) => {
    let rating = ev.target.dataset.value;
    setCurrentRating(rating);
  };

  return (
    <Dialog
      fullScreen={fullScreen}
      open
      onClose={props.handleClose}
      aria-labelledby="responsive-dialog-title"
    >
      <DialogTitle id="responsive-dialog-title">
        Create review for {props.listingName}
      </DialogTitle>
      <DialogContent
        style={{
          overflow: "hidden",
        }}
      >
        <div
          style={{
            minWidth: "40vw",
            overflow: "hidden",
          }}
        >
          <div
            className="rating"
            data-rating={currentRating}
            onMouseOut={setCurrentRating}
            style={{
              textAlign: "center",
            }}
          >
            {[1, 2, 3, 4, 5].map((n) => {
              return (
                <span
                  className="star"
                  key={n}
                  data-value={n}
                  onMouseOver={hoverHandler}
                  onClick={starClickHandler}
                  style={{
                    cursor: "pointer",
                    fontSize: "550%",
                  }}
                >
                  &#9733;
                </span>
              );
            })}
          </div>
          <br />
          <TextareaAutosize
            aria-label="empty textarea"
            placeholder="Empty"
            style={{
              overflow: "hidden",
              paddingTop: "10px",
              paddingBottom: "10px",
              paddingLeft: 0,
              paddingRight: 0,
              width: "99%",
            }}
          />
        </div>
      </DialogContent>
      <DialogActions>
        <Button
          autoFocus
          onClick={props.handleClose}
          variant="outlined"
          color="primary"
        >
          Cancel
        </Button>
        <Button
          onClick={props.handleSubmit}
          color="primary"
          variant="outlined"
          autoFocus
        >
          Write Review
        </Button>
      </DialogActions>
    </Dialog>
  );
};

function hoverHandler(ev: any) {
  const stars = ev.target.parentElement.getElementsByClassName("star");
  const hoverValue = ev.target.dataset.value;

  Array.from(stars).forEach((star: any) => {
    star.style.color =
      hoverValue >= star.dataset.value ? "rgb(255, 56, 92)" : "gray";
  });
}

export default CreateReviewModal;

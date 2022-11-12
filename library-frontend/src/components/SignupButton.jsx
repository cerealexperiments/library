import React from 'react';

function SignupButton() {
  return (
    <>
      <label htmlFor="sign-up-modal" className="btn btn-primary btn-sm text-sm font-bold">Sign up</label>
      {/* Registration modal*/}
      <input type="checkbox" id="sign-up-modal" className="modal-toggle" />
      <div className="modal">
        <div className="modal-box relative">
          <label htmlFor="sign-up-modal" className="btn btn-sm btn-circle absolute right-2 top-2">✕</label>
          <h3 className="text-lg font-bold">Register Now</h3>
          <p className="py-4">Sign up to get access to all the books in our database.</p>
          <div className="form-control w-full max-w-md pb-4">
            <label className="label">
              <span className="label-text">Your email</span>
            </label>
            <input type="text" placeholder="Type here" className="input input-bordered w-full max-w-full" />
          </div>
          <div className="form-control w-full max-w-md">
            <label className="label">
              <span className="label-text">Your password</span>
            </label>
            <input type="text" placeholder="Type here" className="input input-bordered w-full max-w-full" />
          </div>
          <div className="modal-action">
            <button className="btn">Submit</button>
          </div>
        </div>
      </div>
    </>
  );
}

export default SignupButton;
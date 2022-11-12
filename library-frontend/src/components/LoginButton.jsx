import React from 'react';

function LoginButton() {
  return (
    <>
      <label htmlFor="log-in-modal" className="btn btn-outline btn-sm text-sm font-bold">Log in</label>
      {/* Login modal */}
        <input type="checkbox" id="log-in-modal" className="modal-toggle" />
        <div className="modal">
          <div className="modal-box relative">
            <label htmlFor="log-in-modal" className="btn btn-sm btn-circle absolute right-2 top-2">✕</label>
            <h3 className="text-lg font-bold">Sign In</h3>
            <p className="py-4">Log into your account.</p>
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

export default LoginButton;